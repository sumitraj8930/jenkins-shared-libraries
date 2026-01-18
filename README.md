
```markdown
# Jenkins Shared Library for CI/CD Pipelines

This repository provides a modular Jenkins Shared Library to simplify CI/CD pipelines for Docker-based applications.  
It enables reuse of common pipeline steps such as cloning repositories, building Docker images, pushing to DockerHub, and basic testing.

---

## 📦 Overview

This shared library helps to:

- Keep Jenkinsfiles clean and readable
- Avoid duplicate pipeline logic
- Maintain centralized CI/CD functions
- Make pipelines easier to update and scale

---

## 📁 Repository Structure

```

jenkins-shared-libraries/
└── vars/
├── clone.groovy            # Clone source code from Git repository
├── docker_build.groovy     # Build Docker image
├── docker_push.groovy      # Push Docker image to DockerHub
└── hello.groovy            # Test greeting helper

```

---

## 🚀 Usage in Jenkins

### **1. Configure Shared Library**

Go to:

```

Manage Jenkins → Configure System → Global Pipeline Libraries

````

Add the library as:

| Field | Value |
|---|---|
| Library Name | Shared |
| Default Version | main |
| Retrieval Method | Modern SCM |
| SCM | Git |
| Repository URL | https://github.com/<username>/jenkins-shared-libraries.git |

---

### **2. Import & Use in Jenkinsfile**

Example:

```groovy
@Library("Shared") _

pipeline {
    agent any

    stages {
        stage("Greeting") {
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
                    docker_build("notes-app", "latest", "dockerhubUser")
                }
            }
        }

        stage("Push Docker Image") {
            steps {
                script {
                    docker_push("notes-app", "latest", "dockerhubUser")
                }
            }
        }
    }
}
````

---

## 🔑 Requirements

* Jenkins 2.x+
* Docker installed on Jenkins agent
* Jenkins user added to `docker` group
* DockerHub credentials stored in Jenkins Credentials
* GitHub repository access (public or private)
* Optional GitHub Webhook for automatic pipeline triggers

---

## 🎯 Benefits

✔ Clean and modular pipelines
✔ Easy to extend and maintain
✔ Reusable across multiple projects
✔ Works well for Docker CI/CD workflows
✔ Encourages DevOps best practices

---

