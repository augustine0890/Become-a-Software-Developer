## Introduction to GitHub
- Distributed: each developer has a copy of the whole repository on their local machine.
- GitHub is a web-based Git repository hosting service.
- For real configuration and development work, you should use a secure and private Git server, and limit the people authorized to work on it.
- Use the `git clone` command to clone the repository to the server.
- After making changes to our local repository, use the `git push` command to send snapshots to the remote repository.
------
### Basic Interaction with GitHub Cheat-Sheet
- `git clone`: is used to clone a remote repository into a local workspace.
- `git push`: is used to push commits from your local repo to a remote repo.
- `git pull`: is used to fetch the newest updates from a remote repository.

**Caching your GitHub credentials in Git**
`git config --global credential.helper cache`
`# Set git to use the credential memory cache`
`git config --global credential.helper 'cache --timeout=3600'`
`# Set the cache to timeout after 1 hour (setting is in seconds)`