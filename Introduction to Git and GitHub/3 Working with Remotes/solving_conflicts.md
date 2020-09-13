### Solving Conflicts
- Look at the tree of commits on all branches
`git log --graph --oneline --all`
`git log -p origin/master`
- Remove all of the conflict markers and only leave the code as it should be after the merge. Conflict markers aren't required when resolving a merge conflict.
- Switch to new a local branch
`git checkout -b <branch name>`: first create a new branch and then switch to it.
- Rebasing means changing the base commit that's used for our branch.
- `git checkout master` --> `git pull` --> `git log --graph --oneline -all` --> `git checkout <branch name>` --> `git rebase master` --> `git log --graph --oneline -all` --> `git checkout master` --> `git merge <branch name>`
- To remove the remote branch: `git push --delete origin <branch name>`
- To remove the local branch: `git branch -d <branch name>`
- `git rebase <branch name>`: move the current branch on top of the `<branch name>` branch. This makes debugging easier and prevents three-way merges by transferring the completed work from one branch to another.
- Rebasing instead of merging rewrites history and maintains linearity, making for cleaner code.
- Always synchronize your branches before starting any work on your own. This way, when you start changing code, you're starting from the most recent version, minimizing chances of conflicts or the need for rebasing.
- Avoid having very large changes that modify a lot of different things.
- When working on a big change, it makes sence to have a separate feature branch.
- Regularly merge changes made on the master branch back onto the feature branch.
- Have the latest version of the project in the master branch, and the stable version of the project on a separate branch.
- You shouldn't rebase changes that have been pushed to remote repos.
----
- The `git pull` command runs `git fetch` with the given parameters, then calls `git merge` to merge the retrieved branch heads into the current branch.
- `git rebase` is useful for maintaining a clean, linear commit history.
- It's common practice to keep the latest version in the master branch and the latest stable version in a separate branch.
- You can also use `git rebase <branchname>` to change the base of the current branch to be `<branchname>`.