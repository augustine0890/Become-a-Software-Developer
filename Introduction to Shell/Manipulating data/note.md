## Manipulating data
**How can I view a file's contents?**
- Before you rename or delete files, you may want to have a look at their contents. The simplest way to do this is with `cat`, which just prints the contents of files onto the screen. (Its name is short for "concatenate", meaning "to link things together", since it will print all the files whose names you give it, one after the other.)
`cat text.txt`

**How can I view a file's contents piece by piece?**
- You can use `cat` to print large files and then scroll through the output, but it is usually more convenient to __page__ the output. The original command for doing this was called `more`, but it has been superseded by a more powerful command called `less`. (This kind of naming is what passes for humor in the Unix world.) When you `less` a file, one page is displayed at a time; you can press spacebar to page down or type `q` to quit.
- If you give `less` the names of several files, you can type `:n` (colon and a lower-case 'n') to move to the next file, `:p` to go back to the previous one, or `:q` to quit.
- Note: If you view solutions to exercises that use `less`, you will see an extra command at the end that turns paging off so that we can test your solutions efficiently.

**How can I look at the start of a file?**
- The first thing most data scientists do when given a new dataset to analyze is figure out what fields it contains and what values those fields have. If the dataset has been exported from a database or spreadsheet, it will often be stored as __comma-separated values__ (CSV). A quick way to figure out what it contains is to look at the first few rows.
- We can do this in the shell using a command called `head`. As its name suggests, it prints the first few lines of a file (where "a few" means 10), so the command:
`head seasonal/summer.csv`
- What does `head` do if there aren't 10 lines in the file?

**How can I type less?**
- One of the shell's power tools is __tab completion__. If you start typing the name of a file and then press the tab key, the shell will do its best to auto-complete the path. For example, if you type `sea` and press tab, it will fill in the directory name `seasonal/` (with a trailing slash). If you then type `a` and tab, it will complete the path as `seasonal/autumn.csv`.
- If the path is ambiguous, such as `seasonal/s`, pressing tab a second time will display a list of possibilities. Typing another character or two to make your path more specific and then pressing tab will fill in the rest of the name.

**How can I control what commands do?**
- You won't always want to look at the first 10 lines of a file, so the shell lets you change `head`'s behavior by giving it a __command-line flag__ (or just "flag" for short). If you run the command:
`head -n 3 seasonal/summer.csv`
`head` will only display the first three lines of the file. If you run `head -n 100`, it will display the first 100 (assuming there are that many), and so on.
- A flag's name usually indicates its purpose (for example, `-n` is meant to signal "number of lines"). Command flags don't have to be a `-` followed by a single letter, but it's a widely-used convention.
Note: it's considered good style to put all flags _before_ any filenames, so in this course, we only accept answers that do that.

**How can I list everything below a directory?**
- In order to see everything underneath a directory, no matter how deeply nested it is, you can give `ls` the flag `-R` (which means "recursive"). If you use `ls -R` in your home directory, this shows every file and directory in the current level, then everything in each sub-directory, and so on.
- To help you know what is what, `ls` has another flag `-F` that prints a `/` after the name of every directory and a `*` after the name of every runnable program. Run `ls` with the two flags, `-R` and `-F`, and the absolute path to your home directory to see everything it contains. (The order of the flags doesn't matter, but the directory name must come last.)

**How can I get help for a command?**
- To find out what commands do, people used to use the `man` command (short for "manual"). For example, the command `man head` brings up the information
`man` automatically invokes `less`, so you may need to press spacebar to page through the information and `:q` to quit.
- The one-line description under `NAME` tells you briefly what the command does, and the summary under `SYNOPSIS` lists all the flags it understands. Anything that is optional is shown in square brackets `[...]`, either/or alternatives are separated by `|`, and things that can be repeated are shown by `...`, so `head`'s manual page is telling you that you can _either_ give a line count with `-n` or a byte count with `-c`, and that you can give it any number of filenames.

**How can I select columns from a file?**
- `head` and `tail` let you select rows from a text file. If you want to select columns, you can use the command `cut`. It has several options (use `man cut` to explore them), but the most common is something like:
`cut -f 2-5,8 -d , values.csv` --> which means "select columns 2 through 5 and columns 8, using comma as the separator". `cut` uses `-f` (meaning "fields") to specify columns and `-d` (meaning "delimiter") to specify the separator. You need to specify the latter because some files may use spaces, tabs, or colons to separate columns.

**What can't cut do?**
- `cut` is a simple-minded command. In particular, it doesn't understand quoted strings.

**How can I repeat commands?**
- One of the biggest advantages of using the shell is that it makes it easy for you to do things over again. If you run some commands, you can then press the up-arrow key to cycle back through them. You can also use the left and right arrow keys and the delete key to edit them. Pressing return will then run the modified command.
- Even better, `history` will print a list of commands you have run recently. Each one is preceded by a serial number to make it easy to re-run particular commands: just type `!55` to re-run the 55th command in your history (if you have that many). You can also re-run a command by typing an exclamation mark followed by the command's name, such as `!head` or `!cut`, which will re-run the most recent use of that command.

**How can I select lines containing specific values?**
- `head` and `tail` select rows, `cut` selects columns, and `grep` selects lines according to what they contain. In its simplest form, `grep` takes a piece of text followed by one or more filenames and prints all of the lines in those files that contain that text. For example, `grep bicuspid seasonal/winter.csv` prints lines from `winter.csv` that contain "bicuspid".
- `grep` can search for patterns as well. What's more important right now is some of `grep`'s more common flags:
    - `-c`: print a count of matching lines rather than the lines themselves
    - `-h`: do not print the names of files when searching multiple files
    - `-i`: ignore case (e.g., treat "Regression" and "regression" as matches)
    - `-l`: print the names of files that contain matches, not the matches
    - `-n`: print line numbers for matching lines
    - `-v`: invert the match, i.e., only show lines that don't match
- `grep molar seasonal/autumn.csv`: print the content of all of the lines containing the word `molar` in the `seasonal/autumn.csv`
- Invert the match to find all of the lines that don't contain the word `molar` in `seasonal/spring.csv`, and show their line numbers. Remember, it's considered good style to put all of the flags _before_ other values like filenames or the search term "molar".
`grep -v -n molar seasonal/spring.csv`
- Count how many lines contain the word `incisor` in `autumn.csv` and `winter.csv` combined. (Again, run a single command from your home directory.) <br>
`grep -c incisor seasonal/autumn.csv seasonal/winter.csv`

**Why isn't it always safe to treat data as text?**
The `SEE ALSO` section of the manual page for `cut` refers to a command called `paste` that can be used to combine data files instead of cutting them up.