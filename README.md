# the-project

docker build --tag the-project .

docker save -o ./the-project.tar the-project

scp -i /d/AWS/k.shnyrkov.pem ./the-project.tar ec2-user@ec2-3-133-139-186.us-east-2.compute.amazonaws.com:/home/ec2-user/the-project.tar
scp -i /d/AWS/k.shnyrkov.pem ./the-project.tar ec2-user@ec2-3-141-194-95.us-east-2.compute.amazonaws.com:/home/ec2-user/the-project.tar


docker load -i ./the-project.tar

docker run -i -t --rm -d -p 8080:8080 the-project /bin/bash

# dockerhub zorran BU*9^Tmf)92:Y#:


# DockerHub
winpty docker login <- enter creds for docker hub
docker push zorran/the-project

# https://kubernetes.io/ru/docs/reference/kubectl/cheatsheet/
# minikube
minikube start
minikube status

kubectl create deployment the-project --image=zorran/the-project:latest
kubectl expose deployment the-project --type=NodePort --port=8080
minikube service the-project
kubectl port-forward --address 0.0.0.0 service/the-project 7080:8080

# jenkins https://www.jenkins.io/doc/tutorials/tutorial-for-installing-jenkins-on-AWS/
# admin sqlsql
http://ec2-3-141-194-95.us-east-2.compute.amazonaws.com:8080/