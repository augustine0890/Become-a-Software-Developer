##### How does the shell compare to a desktop interface?
- An operating system like Windows, Linux, or Mac OS is a special kind of program. It controls the computer's processor, hard drive, and network connection, but its most important job is to run other programs.

- Since human beings aren't digital, they need an interface to interact with the operating system. The most common one these days is a graphical file explorer, which translates clicks and double-clicks into commands to open files and run programs. Before computers had graphical displays, though, people typed instructions into a program called a command-line shell. Each time a command is entered, the shell runs some other programs, prints their output in human-readable form, and then displays a prompt to signal that it's ready to accept the next command. (Its name comes from the notion that it's the "outer shell" of the computer.)

- Typing commands instead of clicking and dragging may seem clumsy at first, but as you will see, once you start spelling out what you want the computer to do, you can combine old commands to create new ones and automate repetitive operations with just a few keystrokes.

**Where am I**
- To find out the where you are in the filesystem, run the command `pwd` (short for "print working directory"). This prints the absolute path of your __current working directory__, which is where the shell runs commands and looks for files by default.

**How can I identify files and directories?**
- `pwd` tells you where you are. To find out what's there, type `ls` (which is short for "listing") and press the enter key. On its own, `ls` lists the contents of your current directory (the one displayed by `pwd`). If you add the names of some files, `ls` will list them, and if you add the names of directories, it will list their contents.

**How else can I identify files and directories?**
- An absolute path is like a latitude and longitude: it has the same value no matter where you are. A relative path, on the other hand, specifies a location starting from where you are: it's like saying "20 kilometers north".

**How can I move to another directory?**
- Just as you can move around in a file browser by double-clicking on folders, you can move around in the filesystem using the command `cd` (which stands for "change directory").

**How can I move up a directory?**
- The parent of a directory is the directory above it. For example, `/home` is the parent of `/home/repl`, and `/home/repl` is the parent of `/home/repl/seasonal`. You can always give the absolute path of your parent directory to commands like `cd` and `ls`. More often, though, you will take advantage of the fact that the special path `..` (two dots with no spaces) means "the directory above the one I'm currently in". If you are in `/home/repl/seasonal`, then `cd ..` moves you up to `/home/repl`. If you use `cd ..` once again, it puts you in `/home`. One more `cd ..` puts you in the root _directory_ `/`, which is the very top of the filesystem. (Remember to put a space between `cd` and `..` - it is a command and a path, not a single four-letter command.)

- A single dot on its own, `.`, always means "the current directory", so `ls` on its own and `ls .` do the same thing, while `cd .` has no effect (because it moves you into the directory you're currently in).
- One final special path is `~` (the tilde character), which means "your home directory", such as `/home/repl`. No matter where you are, `ls ~` will always list the contents of your home directory, and `cd ~` will always take you home.

**How can I copy files?**
- You will often want to copy files, move them into other directories to organize them, or rename them. One command to do this is `cp`, which is short for "copy". If `original.txt` is an existing file, then:

`cp original.txt duplicate.txt` --> creates a copy of `original.txt` called `duplicate.txt`. If there already was a file called `duplicate.txt`, it is overwritten. If the last parameter to cp is an existing directory, then a command like:

`cp seasonal/autumn.csv seasonal/winter.csv backup` --> copies all of the files into that directory.

**How can I move a file?**
- While `cp` copies a file, `mv` moves it from one directory to another, just as if you had dragged it in a graphical file browser. It handles its parameters the same way as `cp`, so the command:
`mv autumn.csv winter.csv ..` --> moves the files `autumn.csv` and `winter.csv` from the current working directory up one level to its parent directory (because `..` always refers to the directory above your current location).

**How can I rename files?**
- `mv` can also be used to rename files. If you run:

`mv course.txt old-course.txt` --> then the file `course.txt` in the current working directory is "moved" to the file `old-course.txt`. This is different from the way file browsers work, but is often handy.

- One warning: just like `cp`, `mv` will overwrite existing files. If, for example, you already have a file called `old-course.txt`, then the command shown above will replace it with whatever is in `course.txt`.

**How can I delete files?**
- We can copy files and move them around; to delete them, we use `rm`, which stands for "remove". As with `cp` and `mv`, you can give `rm` the names of as many files as you'd like, so:

`rm thesis.txt backup/thesis-2017-08.txt` --> removes both `thesis.txt` and `backup/thesis-2017-08.txt`

- `rm` does exactly what its name says, and it does it right away: unlike graphical file browsers, the shell doesn't have a trash can, so when you type the command above, your thesis is gone for good.

**How can I create and delete directories?**
- `mv` treats directories the same way it treats files: if you are in your home directory and run `mv seasonal by-season`, for example, `mv` changes the name of the seasonal directory to `by-season`. However, `rm` works differently.

- If you try to `rm` a directory, the shell prints an error message telling you it can't do that, primarily to stop you from accidentally deleting an entire directory full of work. Instead, you can use a separate command called `rmdir`. For added safety, it only works when the directory is empty, so you must delete the files in a directory before you delete the directory. (Experienced users can use the `-r` option to `rm` to get the same effect; we will discuss command options in the next chapter.)
- `mkdir directory_name` --> to create a new(empty) directory.

**Wrapping up**
- You will often create intermediate files when analyzing data. Rather than storing them in your home directory, you can put them in `/tmp`, which is where people and programs often keep files they only need briefly. (Note that `/tmp` is immediately below the root directory `/`, not below your home directory.)