### Combining tools
**How can I store a command's output in a file?**
- All of the tools you have seen so far let you name input files. Most don't have an option for naming an output file because they don't need one. Instead, you can use _redirection_ to save any command's output anywhere you want. If you run this command instead:
`head -n 5 seasonal/summer.csv > top.csv` nothing appears on the screen. Instead, head's output is put in a new file called `top.csv`. You can take a look at that file's contents using `cat`: `cat top.csv`
- The greater-than sign `>` tells the shell to redirect `head`'s output to a file. It isn't part of the `head` command; instead, it works with every shell command that produces output.
- Combine `tail` with redirection to save the last 5 lines of `seasonal/winter.csv` in a file called `last.csv`.

**How can I use a command's output as an input?**
- Suppose you want to get lines from the middle of a file. More specifically, suppose you want to get lines 3-5 from one of our data files. You can start by using `head` to get the first 5 lines and redirect that to a file, and then use `tail` to select the last 3:
`head -n 5 seasonal/winter.csv > top.csv
tail -n 3 top.csv`
- Select the last two lines from `seasonal/winter.csv` and save them in a file called `bottom.csv`: `tail -n 2 seasonal/winter.csv > bottom.csv`
- Select the first line from `bottom.csv` in order to get the second-to-last line of the original file: `head -n 1 bottom.csv`

**What's a better way to combine commands?**
- Using redirection to combine commands has two drawbacks:
    1. It leaves a lot of intermediate files lying around (like `top.csv`).
    2. The commands to produce your final result are scattered across several lines of history.
- The shell provides another tool that solves both of these problems at once called a __pipe__. Once again, start by running `head`:
`head -n 5 seasonal/summer.csv`
- Instead of sending head's output to a file, add a vertical bar and the `tail` command _without_ a filename:
`head -n 5 seasonal/summer.csv | tail -n 3`
- The pipe symbol tells the shell to use the output of the command on the left as the input to the command on the right.
- Use `cut` to select all of the tooth names from column 2 of the comma delimited file `seasonal/summer.csv`, then pipe the result to `grep`, with an inverted match, to exclude the header line containing the word "Tooth".
`cut -d , -f 2 seasonal/summer.csv | grep -v -n Tooth`

**How can I combine many commands?**
- You can chain any number of commands together. For example, this command:
`cut -d , -f 1 seasonal/spring.csv | grep -v Date | head -n 10`
    1. select the first column from the spring data;
    2. remove the header line containing the word "Date"; and
    3. select the first 10 lines of actual data.
**How can I count the records in a file?**
- The command `wc` (short for "word count") prints the number of **c**haracters, **w**ords, and **l**ines in a file. You can make it print only one of these using `-c`, `-w`, or `-l` respectively.
- Count how many records in `seasonal/spring.csv` have dates in July 2017 (`2017-07`).
`grep 2017-07 seasonal/spring.csv | wc -l`

**How can I specify many files at once?**
- Most shell commands will work on multiple files if you give them multiple filenames. For example, you can get the first column from all of the seasonal data files at once like this:
`cut -d , -f 1 seasonal/winter.csv seasonal/spring.csv seasonal/summer.csv seasonal/autumn.csv`
- But typing the names of many files over and over is a bad idea: it wastes time, and sooner or later you will either leave a file out or repeat a file's name. To make your life better, the shell allows you to use __wildcards__ to specify a list of files with a single expression. The most common wildcard is `*`, which means "match zero or more characters". Using it, we can shorten the `cut` command above to this:
`cut -d , -f 1 seasonal/*`
`cut -d , -f 1 seasonal/*.csv`
- Write a single command using `head` to get the first three lines from both `seasonal/spring.csv` and `seasonal/summer.csv`, a total of six lines of data, but not from the autumn or winter data files. Use a wildcard instead of spelling out the files' names in full.
`head -n 3 seasonal/s*`

**What other wildcards can I use?**
The shell has other wildcards as well, though they are less commonly used:

- `?` matches a single character, so `201?.txt` will match `2017.txt` or `2018.txt`, but not `2017-01.txt`.
- `[...]` matches any one of the characters inside the square brackets, so `201[78].txt` matches `2017.txt` or `2018.txt`, but not `2016.txt`.
- `{...}` matches any of the comma-separated patterns inside the curly brackets, so `{*.txt, *.csv}` matches any file whose name ends with `.txt` or `.csv`, but not files whose names end with .`pdf`.
- Which expression would match `singh.pdf` and `johel.txt` but not `sandhu.pdf` or `sandhu.txt`?
`{singh.pdf, j*.txt}`

**How can I sort lines of text?**
- As its name suggests, `sort` puts data in order. By default it does this in ascending alphabetical order, but the flags `-n` and `-r` can be used to sort numerically and reverse the order of its output, while `-b` tells it to ignore leading blanks and `-f` tells it to fold case (i.e., be case-insensitive). Pipelines often use `grep` to get rid of unwanted records and then `sort` to put the remaining records in order.
- Sort the names of the teeth in `seasonal/winter.csv` (not summer.csv) in descending alphabetical order. To do this, extend the pipeline with a `sort` step.
`cut -d , -f 2 seasonal/winter.csv | grep -v Tooth | sort -r`
- `sort` has many uses. For example, piping `sort -n` to `head` shows you the largest values.

**How can I remove duplicate lines?**
Another command that is often used with `sort` is `uniq`, whose job is to remove duplicated lines. More specifically, it removes adjacent duplicated lines. If a file contains:
`2017-07-03`
`2017-07-03`
`2017-08-03`
`2017-08-03`
then `uniq` will produce:
`2017-07-03`
`2017-08-03`
but if it contains:
`2017-07-03`
`2017-08-03`
`2017-07-03`
`2017-08-03`
then `uniq` will print all four lines. The reason is that `uniq` is built to work with very large files. In order to remove non-adjacent lines from a file, it would have to keep the whole file in memory (or at least, all the unique lines seen so far). By only removing adjacent duplicates, it only has to keep the most recent unique line in memory.
- Write a pipeline to:
    -   get the second column from `seasonal/winter.csv`,
    -   remove the word `"Tooth"` from the output so that only tooth names are displayed,
    -   sort the output so that all occurrences of a particular tooth name are adjacent; and
    - display each tooth name once along with a count of how often it occurs.
- Use `uniq -c` to display unique lines with a count of how often each occurs rather than using `uniq` and `wc`.
`cut -d , -f 2 seasonal/winter.csv | grep -v Tooth | sort | uniq -c`

**How can I save the output of a pipe?**
- The shell lets us redirect the output of a sequence of piped commands:
`cut -d , -f 2 seasonal/*.csv | grep -v Tooth > teeth-only.txt`
- However, `>` must appear at the end of the pipeline: if we try to use it in the middle, like this:
`cut -d , -f 2 seasonal/*.csv > teeth-only.txt | grep -v Tooth`
then all of the output from `cut` is written to `teeth-only.txt`, so there is nothing left for `grep` and it waits forever for some input.

**How can I stop a running program?**
- The commands and scripts that you have run so far have all executed quickly, but some tasks will take minutes, hours, or even days to complete. You may also mistakenly put redirection in the middle of a pipeline, causing it to hang up. If you decide that you don't want a program to keep running, you can type `Ctrl` + `C` to end it. This is often written `^C` in Unix documentation; note that the `'c'` can be lower-case.

**Wrapping up**
- To wrap up, you will build a pipeline to find out how many records are in the shortest of the seasonal data files.
- Use `wc` with appropriate parameters to list the number of lines in all of the seasonal data files:
`wc -l seasonal/*.csv`
- Add another command to the previous one using a pipe to remove the line containing the word "total".
`wc -l seasonal/*.csv | grep -v total`
- Add two more stages to the pipeline that use `sort -n` and `head -n 1` to find the file containing the fewest lines.
`wc -l seasonal/*.csv | grep -v total | sort -n | head -n 1`