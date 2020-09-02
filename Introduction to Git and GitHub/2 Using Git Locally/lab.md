## Explore repository
- There is a Git repo named `food-scripts`
- Navigate to the repo
`cd ~/food-scripts`
- List the files using the `ls`
- View __favorite_foods.log__: `cat favorite_foods.log`
- Execute `food_count.py`
- Execute `ffood_question.py`: this gives us an error.

## Understanding the repository
- `git status`: this displays paths that have differences between the index file and the current HEAD commit.
- `git log`: this lists the commits done in the repository in reverse chronological order; that is, the most recent commits show up first. This command lists each commit with its SHA-1 checksum, the author's name and email, date, and the commit message.

## Add a new feature
- `git branch improve-output`: create a branch named __improve-output__ 
- `git checkout improve-output`: move to the `improve-output` branch from the master branch. 
- `nano food_count.py`: open `food_count.py`
    - Add the line: ```print("Favourite foods, from most popular to least popular")``` before **printing for loop**.
- Then run the script `food_count`.py again to see the output:
- `git add food_count.py`: adding this script to the staging area.
- `git commit -m "Adding a line in the output describing the utility of food_count.py script"`: commit the changes you've done in the `improve-output` branch.

## Fix the script
- `./food_question.py`: run the file again to view the error.
- `git log`
- Here, you'll see the commits in reverse chronological order and find the commit having **"Rename item variable to food_item"** as a commit message. Make sure to note the commit ID for this particular commit.
- `git revert [commit-ID]`: revert with commit ID
- Then continue by clicking Ctrl-o, the Enter key, and Ctrl-x.
- `./food_question.py`

## Merge operation
- `git checkout master`: switch to the master branch
- `git merge improve-output`: merge the branch `improve-output` into the master.
- `git status`
- `git log --graph --oneline`: to track the git commit logs.
- `./food_question.py`
