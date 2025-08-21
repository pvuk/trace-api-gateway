Open Git Hub Desktop app
> Goto File > Create a new repository 
> Name: name of the project
> Local Path: Locate root folder of existing project (Note: If you select existing project it will create sub folder, make sure selected folder should be root. If your project 'trace-bank' available in 'd:\workspace\sts\' then select upto 'sts' only)
> Step 2: Right side click on "Publish repository" > Click "Publish repository"

#If repository already created in git and try to link local project with git, follow below steps
🔹 Step 2: Open GitHub Desktop
Launch GitHub Desktop.
Go to File > Add Local Repository.
Select the folder containing your trace-api-gateway project.
Click Add Repository.
🔹 Step 3: Link to the Remote Repository
Go to Repository > Repository Settings.
Under Remote, click Add (or edit if one already exists).
Enter:
Name: origin
URL: https://github.com/pvuk/trace-api-gateway.git
Click Save.
🔹 Step 4: Commit Your Project Files
GitHub Desktop will show all uncommitted files.
Add a commit message (e.g., Initial commit of trace-api-gateway project).
Click Commit to main (or your current branch).
🔹 Step 5: Push to GitHub
Click Push origin (top right).
Your files will be uploaded to the GitHub repository.

#Fix Issue: If repository already there and git hub try to create one more, at that time follow below steps
"Repository creation failed. (name already exists on this account)"

means that GitHub Desktop is trying to create a new repository on GitHub with the name trace-git-gateway, but a repository with that name already exists under your GitHub account (pvuk).

✅ What You Should Do Instead
Since your goal is to commit your local trace-api-gateway project to an existing GitHub repository (https://github.com/pvuk/trace-api-gateway.git), you don’t need to publish a new repository. You just need to link your local folder to the existing remote repo.

🔧 Fix Steps
1. Cancel the Publish Attempt
Click Cancel on the "Publish repository" popup.

2. Add the Remote Manually
In GitHub Desktop:

Go to Repository > Repository Settings.
Under Remote, click Add.
Fill in:
Name: origin
URL: https://github.com/pvuk/trace-api-gateway.git
Click Save.
3. Commit and Push
Make sure your local folder has the project files.
GitHub Desktop will show them as changes.
Add a commit message and click Commit to main.
Then click Push origin to upload to GitHub.

# one more way of doing, follow below steps
✅ Here's How to Push Your Local Project to an Existing GitHub Repo Using GitHub Desktop (No Git Bash)
🔹 Step 1: Move Your Project to a New Empty Folder
GitHub Desktop can only clone into empty folders. So:

Create a new empty folder (e.g., C:\GitHubProjects\trace-api-gateway).
Open GitHub Desktop.
Go to File > Clone Repository.
Select your existing GitHub repo: pvuk/trace-api-gateway.
Choose the empty folder you just created as the Local Path.
Click Clone.
🔹 Step 2: Copy Your Project Files
After cloning, go to the folder where GitHub Desktop cloned the repo.
Copy all your project files from your original trace-api-gateway folder into this cloned folder.
🔹 Step 3: Commit and Push
Open GitHub Desktop — it will detect the new files.
Add a commit message (e.g., Initial commit of trace-api-gateway project).
Click Commit to main.
Click Push origin to upload the files to GitHub.