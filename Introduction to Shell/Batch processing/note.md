### Batch processing
**How does the shell store information?**
- Like other programs, the shell stores information in variables. Some of these, called __environment variables__, are available all the time. Environment variables' names are conventionally written in upper case, and a few of the more commonly-used ones are shown below.
- Use `set` and `grep` with a pipe to display the value of `HISTFILESIZE`, which determines how many old commands are stored in your command history. What is its value?
`set | grep HISTFILESIZE`

**How can I print a variable's value?**
- A simpler way to find a variable's value is to use a command called `echo`, which prints its arguments. Typing
`echo $USER`
- This is true everywhere: to get the value of a variable called `X`, you must write `$X`. (This is so that the shell can tell whether you mean "a file named X" or "the value of a variable named X".)
- The variable `OSTYPE` holds the name of the kind of operating system you are using. Display its value using `echo`.

**How else does the shell store information?**
- The other kind of variable is called a __shell variable__, which is like a local variable in a programming language.
- To create a shell variable, you simply assign a value to a name:
`training=seasonal/summer.csv` _without_ any spaces before or after the `=` sign. Once you have done this, you can check the variables's value with:
`echo $training`
- Define a variable called `testing` with the value `seasonal/winter.csv`: `testing=seasonal/winter.csv`
- Use `head -n 1 $testing` to get the first line from  `seasonal/winter.csv`

**How can I repeat a command many times?**
- Shell variables are also used in __loops__, which repeat commands many times. If we run this command:
`for filetype in gif jpg png; do echo $filetype; done`
it produces:
`gif`
`jpg`
`png`
- Notice these things about the loop:
    1.  The structure is `for` ...variable... `in` ...list... `; do` ...body... `; done`
    2. The list of things the loop is to process (in our case, the words `gif`, `jpg`, and `png`).
    3. The variable that keeps track of which thing the loop is currently processing (in our case, `filetype`).
    4. The body of the loop that does the processing (in our case, `echo $filetype`).
- Notice that the body uses `$filetype` to get the variable's value instead of just `filetype`, just like it does with any other shell variable. Also notice where the semi-colons go: the first one comes between the list and the keyword `do`, and the second comes between the body and the keyword `done`.
`for filetype in docx odt pdf; do echo $filetype; done`

**How can I repeat a command once for each file?**
You can always type in the names of the files you want to process when writing the loop, but it's usually better to use wildcards. Try running this loop in the console:
`for filename in seasonal/*.csv; do echo $filename; done`
It prints:
`seasonal/autumn.csv`
`seasonal/spring.csv`
`seasonal/summer.csv`
`seasonal/winter.csv`
because the shell expands `seasonal/*.csv` to be a list of four filenames before it runs the loop.
`for filename in people/*; do echo$filename; done`

**How can I record the names of a set of files?**
- People often set a variable using a wildcard expression to record a list of filenames. For example, if you define `datasets` like this:
`datasets=seasonal/*.csv`
you can display the files' names later using:
`for filename in $datasets; do echo $filename; done`
`files=seasonal/*.csv`
`for f in $files; do echo $f; done`

**How can I run many commands in a single loop?**
- Printing filenames is useful for debugging, but the real purpose of loops is to do things with multiple files. This loop prints the second line of each data file:
`for file in seasonal/*.csv; do head -n 2 $file | tail -n 1; done`: it has the same structure as the other loops you have already seen: all that's different is that its body is a pipeline of two commands instead of a single command.
`for file in seasonal/*.csv; do grep 2017-07 $file | tail -n 1; done`

**Why shouldn't I use spaces in filenames?**
- It's easy and sensible to give files multi-word names like `July 2017.csv `when you are using a graphical file explorer. However, this causes problems when you are working in the shell. For example, suppose you wanted to rename `July 2017.csv` to be `2017 July data.csv`. You cannot type:
`mv July 2017.csv 2017 July data.csv`
because it looks to the shell as though you are trying to move four files called `July`, `2017.csv`, `2017`, and `July` (again) into a directory called `data.csv`. Instead, you have to quote the files' names so that the shell treats each one as a single parameter:
`mv 'July 2017.csv' '2017 July data.csv'`

**How can I do many things in a single loop?**
- The loops you have seen so far all have a single command or pipeline in their body, but a loop can contain any number of commands. To tell the shell where one ends and the next begins, you must separate them with semi-colons:
`for f in seasonal/*.csv; do echo $f; head -n 2 $f | tail -n 1; done`