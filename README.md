
# Jenkins Shared Libraries

This repository contains reusable functions for Jenkins pipelines. The goal is to make CI/CD pipelines cleaner, modular, and easier to maintain.

## 📁 Folder Structure

```
jenkins-shared-libraries/
 └── vars/
      ├── clone.groovy
      ├── docker_build.groovy
      ├── docker_push.groovy
      └── hello.groovy
```

## 🧩 Functions Overview

### **1. clone.groovy**

* Used for cloning repositories
* Supports custom Git URLs and branches

### **2. docker_build.groovy**

* Builds Docker images using Docker CLI
* Allows passing tags and build context

### **3. docker_push.groovy**

* Logs into Docker registry
* Pushes images to registry
* Can be used with private or public registries

### **4. hello.groovy**

* Simple test function for verifying shared library setup

## 🚀 Example Usage in Jenkinsfile

```groovy
@Library('jenkins-shared-libraries') _

pipeline {
    agent any

    stages {
        stage('Clone Repo') {
            steps {
                clone(repo: 'https://github.com/user/app.git', branch: 'main')
            }
        }

        stage('Build Docker Image') {
            steps {
                docker_build(imageName: 'myapp:latest', context: '.')
            }
        }

        stage('Push Docker Image') {
            steps {
                docker_push(image: 'myapp:latest', registry: 'docker.io', credentialsId: 'docker-creds')
            }
        }

        stage('Test Library') {
            steps {
                hello()
            }
        }
    }
}
```

## 🎯 Why Use Shared Libraries?

* Avoid duplicate code across pipelines
* Centralized updates for all jobs
* Cleaner Jenkinsfiles
* Easier CI/CD scaling in teams

## 🛠 Requirements

* Jenkins with Shared Libraries enabled
* Docker installed (for build/push flows)
* Valid Docker registry credentials

