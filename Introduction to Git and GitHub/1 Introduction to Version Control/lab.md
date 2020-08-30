# Introductin to Git

**What you'll do**
- Create a git repository
- Add files to this repository
- Edit the files
- Commit the changes to the repository

### Accessing the virtual machine
- Download PEM.
- Linux: `Ctrl+Alt+t` or Mac: `cmd + space` and search for __terminal__.
- The path of the PEM key will be __~/Downloads/qwikLABS-XXXXX.pem__
`chmod 600 ~/Downloads/qwikLABS-XXXXX.pem`
`ssh -i ~/Downloads/qwikLABS-XXXXX.pem username@External Ip Address`

### Install Git
- Fresh index of the packages
`sudo apt update`
- Install Git using apt
`sudo apt install git`
- Check the installed version of git
`git --version`

### Initalize a new repository
- Create a directory to store your project in
`mkdir my-git-repo`
- Navigate to the directory
`cd my-git-repo`
- Initialize a new repository
`git init`

The __git init__ command creates a new Git repository. In our case, it transformed the current directory into a Git repository. It can also be used to convert an existing, unversioned project to a Git repository or to initialize a new, empty repository.

Executing __git init__ creates a __.git__ subdirectory in the current working directory, which contains all of the necessary Git metadata for the new repository. This metadata includes subdirectories for objects, refs, and template files. A HEAD file is also created which points to the currently checked out commit.

### Configure Git
- Set Git username
`git config --global user.name "Your Name"`
- Set email address
`git config --global user.email "youremail@example.com"`

### Git Operations
- Create a text file named README
`nano README`
- Type any text within the file
`This is my first repository.`

Save the file by pressing __Ctrl-o, Enter key, and Ctrl-x__

- Check the status
`git status`

You can now see the file you created, README, under the section __Untracked files.__ Git isn't tracking the files yet. To track the files, we have to commit these files by adding them to the staging area.

- Add the file to the staging area
`git add README`
- Commit the changes
`git commit`

This now opens an editor, asking you to type a commit message. Every commit has an associated commit message. A commit message is a log message from the user describing the changes.
Enter the commit message of your choice.
`This is my first commit!`
Save the file by pressing __Ctrl-o, Enter key, and Ctrl-x__

- Re-edit the file again
`nano README`
- Add the description of your choice
`A repository is a location where all the files of a particular project are stored.`
Save the file by pressing __Ctrl-o, Enter key, and Ctrl-x__

- Check the status
`git status`
- View the changes made to file
`git diff README`
- Add these changes to the staging area
`git add README`
`git status`
- Commit the file
`git commit -m "This is my second commit."

The command __git commit__ with -m flag takes the commit message, too. This is different to the command without flag, where you had to type the commit message within the editor. If multiple __-m__ flags are given to the command, it concatenates the values as separate paragraphs.

- View all the commits
`git log`

Git log command shows the commit history of the repository. It shows all the commits on the repository represented by a unique commit ID at the top of each commit. It also shows the author, date, and time and the commit message associated with the commits.