- A shortcut to stage any changes to tracked files and commit them in one step.
`git commit -a`
- If we're making a small change and want to skip the staging step, we want to add to the git commit command?
`git commit -a -m "Has changed some thing."`
- Git uses the HEAD alias to represent the currently checked-out snapshot of your project.
- Look the lines has changed in each commit
`git log -p`
- If we want to see a specific commit and use along with the commit ID?
`git show` will show information about the commit and its associated patch.
`git log --stat`
- Review changes before adding them
`git diff --stat`
`git add -p`
- Remove files from the working tree and from the index
`git rm [<pathspec>]`
- Move or rename a file, a directory
`git mv <source> <destination>`
- Specifies intentionally untracked files to ignore
`.gitignore`
    - `echo .DS_STORE > .gitignore`

----
## Advanced Git Cheat Sheet
- Stage files automatically: `git commit -a`
- Produces patch text: `git log -p`
- Shows various objects: `git show`	
- Is similar to the Linux `diff` command, and can show the differences in various commits: `git diff`
- An alias to --cached, this will show all staged files compared to the named commit: `git diff --staged`
- Allows a user to interactively review patches to add to the current commit: `git add -p`
- Similar to the Linux `mv` command, this moves a file: `git mv`
- Similar to the Linux `rm` command, this deletes, or removes a file: `git rm`
- Some common `.gitignore` configuration
```
# Compiled source #
###################
*.com
*.class
*.dll
*.exe
*.o
*.so

# Packages #
############
# it's better to unpack these files and commit the raw source
# git has its own built in compression methods
*.7z
*.dmg
*.gz
*.iso
*.jar
*.rar
*.tar
*.zip

# Logs and databases #
######################
*.log
*.sql
*.sqlite

# OS generated files #
######################
.DS_Store
.DS_Store?
._*
.Spotlight-V100
.Trashes
ehthumbs.db
Thumbs.db
```