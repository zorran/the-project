# the-project

#AWS console
# k.shnyrkov@epam.com   DAG7PE[XTF+*Vi=
# root.k.shnyrkov       )@XHkURd!2+a[f*
# service.k.shnyrkov    L]oc1E'hAqcI'gr
# zorran                Z^6FNPcR)zQ1G2Q

# API auth
Access key          IDAKIAT2UGU7XQJHSFX6AW
Secret access key   lXiWK8hOYlLl65XYZinqYSkV05FneQRdiQwQcp01
Base64              bFhpV0s4aE9ZbExsNjVYWVppbnFZU2tWMDVGbmVRUmRpUXdRY3AwMQ

zorran (access key and secret key):
AKIAT2UGU7XQMZAVUXY2
8h3+EjFv4pKQ5CEHlcSfNz+pk0L6D7qV5WjG3sSL

# java
spring

docker build --tag the-project .

docker save -o ./the-project.tar the-project

scp -i /d/AWS/k.shnyrkov.pem ./the-project.tar ec2-user@ec2-3-133-139-186.us-east-2.compute.amazonaws.com:/home/ec2-user/the-project.tar
scp -i /d/AWS/k.shnyrkov.pem ./the-project.tar ec2-user@ec2-3-141-194-95.us-east-2.compute.amazonaws.com:/home/ec2-user/the-project.tar
scp -i /d/AWS/k.shnyrkov.pem ./the-project-1.0-SNAPSHOT.jar ec2-user@ec2-3-137-183-47.us-east-2.compute.amazonaws.com:/home/ec2-user/the-project-1.0-SNAPSHOT.jar



docker load -i ./the-project.tar

docker run -i -t --rm -d -p 8080:8080 the-project /bin/bash

# dockerhub zorran BU*9^Tmf)92:Y#:


# DockerHub
winpty docker login <- enter creds for docker hub
docker push zorran/the-project

# https://kubernetes.io/ru/docs/reference/kubectl/cheatsheet/
# minikube
sudo systemctl start docker
minikube start
minikube status

kubectl create deployment the-project --image=zorran/the-project:latest
kubectl expose deployment the-project --type=NodePort --port=8080
minikube service the-project
kubectl port-forward --address 0.0.0.0 service/the-project 7080:8080

# jenkins https://www.jenkins.io/doc/tutorials/tutorial-for-installing-jenkins-on-AWS/
# admin sqlsql
http://ec2-3-141-194-95.us-east-2.compute.amazonaws.com:8080/

# XRay
# start xray -n us-east-2


#Secret
kubectl create secret generic dynamodb-seciruty --from-literal=amazon.aws.accesskey=AKIAT2UGU7XQMZAVUXY2 --from-literal=amazon.aws.secretkey=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
