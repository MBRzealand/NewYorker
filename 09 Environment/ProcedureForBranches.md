# Branching procedure for New Yorker Project:

### **WorkFlow:**

1. Create a new branch named after the naming conventions below
2. When a feature is ready for merging, commence merging procedure
3. When a feature is merged into Master, the branch must be deleted.

### **Naming conventions**

Name the branch after the issue title and camel case it.

**Example:**  
*exampleIssueName*

### **Create new branch through Github.com:**

1. Open repository
2. Press the Master Branch button

![image](https://user-images.githubusercontent.com/70659124/118616413-f57b4600-b7c1-11eb-8a45-052b77d9243f.png)

3. Name the branch by following the naming conventions.

![image](https://user-images.githubusercontent.com/70659124/118616654-2e1b1f80-b7c2-11eb-9202-c2edc3fca187.png)

4. Click the "create" button

![image](https://user-images.githubusercontent.com/70659124/118616759-44c17680-b7c2-11eb-9827-a8204878d099.png)

<br>

### Create branch through Git (command line)**

Start empty repository:

```cmd
git init
```

Add remote:

```cmd
git remote add origin YOUR_REPO_URL_HERE.git
```

Pull changes from master branch:

```cmd
git pull origin master
```

Create new branch:

```cmd
git checkout -b [branch_name]
```

Change to a existing branch:

```cmd
git checkout [branch_name]
```

Add Changes:

```cmd
git add .
```

Commit Changes:

```cmd
git commit -m “your_message”
```

Push to branch:

```cmd
git push origin [branch_name]
```

### **Delete Branch through Github.com.**

1. Click the branch button.
2. Find the branch you want to delete after reviewing it.
3. Click the delete icon next to the branch name.

### **Delete Branch Through IntelliJ**

1. Click the branch button.

![image](https://user-images.githubusercontent.com/70659124/118618309-c534a700-b7c3-11eb-8790-404d2aecdc4a.png)

2. Find the feature branch you want to delete and click the delete button.

![image](https://user-images.githubusercontent.com/70659124/118618351-cf56a580-b7c3-11eb-9772-f1771831f14e.png)
