- Checking out the orginal file from the latest storage snapshot.  Restores files to the latest stored snapshot, reverting any changes before staging.
`git checkout <file>` (
It reverts changes to modified files before they are staged)
- `git add *`: Add all files in the current directory, except for files whose name begin with a dot.
- To unstage
`git reset HEAD <file>`
- `git commit --amend`: allows us to modify and add changes to the most recent commit (overwrite the previous commit)
    - Avoid amending commits that have already been made public
-  `git revert HEAD`: a new commit is created with inverse changes. This cancels previous changes instead of making it as though the original commit never happened.
- `git revert <id>`
- SHA1 hash numbers that Git uses to identify commits. They are created using the commit message, date, author, and the snapshot taken of the working tree.
----
## Git Revert Cheat Sheet
- `git checkout` is effectively used to switch branches.

- `git reset` basically resets the repo, throwing away some changes. It’s somewhat difficult to understand, so reading the examples in the documentation may be a bit more useful.

- `git commit --amend` is used to make changes to commits after-the-fact, which can be useful for making notes about a given commit. It will overwrite the previous commit with what is already in the staging area.

- `git revert` makes a new commit which effectively rolls back a previous commit. It’s a bit like an undo command. It will create a new commit to reverse the previous one, and is the best option for undoing commits on public branches