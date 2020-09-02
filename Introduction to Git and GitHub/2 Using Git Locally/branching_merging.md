#### Branch
- A pointer to a particular commit
- The default branch that git creates for you when a new repository is initialized is called __master__.
- By creating a new branch, we can experiment without breaking what already works. To enable changes to be worked on without disripting the most current working state.
- We can use the git branch command to list, create, delete, and manipulate branches.
- `git branch <new-feature>`: create a branch
- `git checkout`: updating the working tree to match the selected branch. The HEAD is moved to the relevant commit on the specified branch.
- `git checkout <branch-name>`: to check out the latest snapshot for both files and for branches.
- `git checkout -b <new-branch>`: creates a new branch and switche (branch).
- `git branch -d <branch-name>`: delete a branch.
- `git branch -D <branch-name>`: forcibly deletes the branch.

#### Merging
- The term that Git uses for combining branched data and history together.
- `git merge <branch-name>`: take the independent snapshots and history of one Git branch, and tangle them into another. Both branches are pointed at the same commit.
- Git uses two different algorithms to perform a merge: fast-forward and three-way merge.
- `git merge --abort`: if there are merge conflicts (meaning files are incompatible), --abort can be used to abort the merge action.
- `git log --graph --oneline`: this shows a summarized view of the commit history for a repo.