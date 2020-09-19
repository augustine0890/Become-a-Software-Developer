### Pull Requests
------
- Forking: a way of creating a copy of the given repository so that it belongs to our user.
- Pull request: a commit or series of commits that you send to the owner of the repository so that they incorporate it into their tree. A request sent to the owner and collaborators of the target repository to pull your recent changes.
`git push -u origin <branch-name>`
`git rebase -i`
- Squash combines the commit messages into one. Fixup discards the new commit message. The fixup operation will keep the original message and discard the message from the fixup commit, while squash combines them.
- `git push -f`: combination of command and flags will force Git to push the current snapshot to the repos as it is.
- The `pick` keyword takes the commits and rebases them against the branch we have chosen.
- Git Fork and Pull Rquest [Cheat Sheet](https://docs.github.com/en/github/collaborating-with-issues-and-pull-requests/about-pull-request-merges)