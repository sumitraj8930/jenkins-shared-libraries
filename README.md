
```markdown
# Jenkins Shared Libraries

This repository contains reusable Jenkins Pipeline functions implemented using the Jenkins Shared Library feature.  
These functions help to modularize and clean up CI/CD pipelines for Docker-based applications.

---

## 📁 Repository Structure

```

jenkins-shared-libraries/
└── vars/
├── clone.groovy
├── docker_build.groovy
├── docker_push.groovy
└── hello.groovy

```

- `clone.groovy` → Clones source code from Git repository
- `docker_build.groovy` → Builds Docker image
- `docker_push.groovy` → Pushes Docker image to DockerHub
- `hello.groovy` → Simple test function for greetings

---

## 🚀 How to Use in Jenkins Pipeline

### 1. Configure Shared Library in Jenkins

Go to:

```

Manage Jenkins → Configure System → Global Pipeline Libraries

````

Add:

- Library Name: **Shared**
- Default Version: **main**
- Retrieval Method: **Modern SCM**
- SCM: **Git**
- Repository URL:  
  `https://github.com/<username>/jenkins-shared-libraries.git`

---

### 2. Import & Use in Jenkinsfile

Example Jenkinsfile:

```groovy
@Library("Shared") _

pipeline {
    agent { label "vinod" }

    stages {
        stage("Hello") {
            steps {
                script {
                    hello()
                }
            }
        }

        stage("Clone") {
            steps {
                script {
                    clone("https://github.com/user/repo.git", "main")
                }
            }
        }

        stage("Build Docker Image") {
            steps {
                script {
                    docker_build("notes-app", "latest", "username")
                }
            }
        }

        stage("Push Image") {
            steps {
                script {
                    docker_push("notes-app", "latest", "username")
                }
            }
        }
    }
}
````

---

## 🧩 Requirements

* Jenkins 2.0+
* Docker installed on build agent
* Credentials configured for DockerHub
* GitHub repository configured for source code

---

## 🎯 Advantages of Using Shared Libraries

✔ Removes duplicate pipeline code
✔ Centralized CI/CD logic
✔ Cleaner and easier Jenkinsfiles
✔ Reusable Docker functions
✔ Faster pipeline updates across projects

