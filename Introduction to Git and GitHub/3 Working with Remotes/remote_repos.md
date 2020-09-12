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