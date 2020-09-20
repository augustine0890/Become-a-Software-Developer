### Pushing Local Commits to Github
- Forking and detect function behavior
- Fork an existing repository: `google/it-cert-automation-practice`
- Clone the repository: `git clone https://github.com/[git-username]/it-cert-automation-practice.git`
- Go to the `it-cert-automation-practice`: `cd ~/it-cert-automation-practice`
- `git remote -v`
- In terms of source control, you're **"downstream"** when you copy (clone, checkout, etc) from a repository. Information is flowed "downstream" to you.
- When you make changes, you usually want to send them back **"upstream"** so they make it into that repository so that everyone pulling from the same source is working with all the same changes. This is mostly a social issue of how everyone can coordinate their work rather than a technical requirement of source control. You want to get your changes into the main project so you're not tracking divergent lines of development.
- Setting the upstream for a fork: `git remote add upstream https://github.com/[git-username]/it-cert-automation-practice.git`

- Create a new branch named `improve-username-behavior`
`git branch improve-username-behavior`
`git checkout improve-username-behavior`
`cd ~/it-cert-automation-practice/Course3/Lab4`

- Commit the changes: `git status`
`git add validations.py`
`git commit`
- Enter a commit message of your choice and append a line:
`Closes: #1
Updated validations.py python script.
Fixed the behavior of validate_user function in validations.py.`

- Push changes: `git push origin improve-username-behavior`