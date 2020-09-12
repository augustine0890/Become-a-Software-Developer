## Using a Remote Repository
- If the master repository receives a major update since the last local copy was synced? Git will let you know it's time for an update.
- The remote 'origin' is a convention to use for the primary centralized repository
`git remote`
`git remote -v`
`git remote show origin`
- If we want to make a change to a remote branch:
    - `pull` the remote branch, `merge` it with the local `branch`, then `push` it back to its `origin`.
- `git fetch` fetches remote updates but doesn't merge; `git pull` fetches remote updates and merges.
- `git pull` instantl merges while `git fetch` only retrives remote updates.
- `git log -p -1`
- As long as there are no conflicts, Git will move the current branch tip up to the target branch tip and combine histories of both commits. Git pull perform will merge using `Fast-forward merge` type.
-------
### Git Remotes Cheat-Sheet
- `git remote`: Lists remote repos
- `git remove -v`: List remote repos verbosely
- `git remote show <name>`: Describes a single remote repo
- `git remote update`: Fetches the most up-to-date objects
- `git fetch`: Downloads specific objects
- `git branch -r`: List remote branches; can be combined with other branch arguments to manage remote branches.
-------
- `git remote update`: will fetch the contents of all remote branches and allow us to merge the contents ourselves and get the contents of a remote branch without automatically merging.
- `git fetch`: will download remote updates, such as objects and refs, from the remote branch.
- An explicit merge creates a new merge commit. This alters the commit history and explicitly shows where a merge was executed.