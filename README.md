# the-project
пример соединение с инстансом
ssh -i "k.shnyrkov.pem" ec2-user@ec2-3-144-80-244.us-east-2.compute.amazonaws.com
# java
spring

docker build --tag the-project .

docker save -o ./the-project.tar the-project

scp -i /d/AWS/k.shnyrkov.pem ./the-project.tar ec2-user@ec2-3-133-139-186.us-east-2.compute.amazonaws.com:/home/ec2-user/the-project.tar
scp -i /d/AWS/k.shnyrkov.pem ./the-project.tar ec2-user@ec2-3-141-194-95.us-east-2.compute.amazonaws.com:/home/ec2-user/the-project.tar
scp -i /d/AWS/k.shnyrkov.pem ./the-project-1.0-SNAPSHOT.jar ec2-user@ec2-3-137-183-47.us-east-2.compute.amazonaws.com:/home/ec2-user/the-project-1.0-SNAPSHOT.jar



docker load -i ./the-project.tar

docker run -i -t --rm -d -p 8080:8080 the-project /bin/bash
sudo docker run -i -t --rm -d -p 8080:8080 zorran/the-project:latest

# dockerhub zorran BU*9^Tmf)92:Y#:


# DockerHub
winpty docker login <- enter creds for docker hub
docker login -u zorran -p SqlsqlLA1U2C
docker push zorran/the-project

# https://kubernetes.io/ru/docs/reference/kubectl/cheatsheet/
# Установка docker
sudo service docker start
sudo usermod -a -G docker ec2-user
sudo chmod 666 /var/run/docker.sock
# Установка kubectl
curl -LO https://storage.googleapis.com/kubernetes-release/release/`curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt`/bin/linux/amd64/kubectl
chmod +x ./kubectl
sudo mv ./kubectl /usr/local/bin/kubectl
kubectl version --client
# Установка minikube
curl -Lo minikube https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64 && chmod +x minikube
sudo mkdir -p /usr/local/bin/
sudo install minikube /usr/local/bin/
minikube start
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

#Update
kubectl set image deployment/the-project the-project=zorran/the-project:latest
kubectl rollout restart deployment/the-project
kubectl rollout history deployment/the-project

собрать докер локально, указать увеличившивающееся номер образа
запушать докер в докер хаб
на ec2(medium) выполнить kubectl apply -f deployment.yml

#Secret
kubectl create secret generic dynamodb-seciruty --from-literal=amazon.aws.accesskey=AKIAT2UGU7XQMZAVUXY2 --from-literal=amazon.aws.secretkey=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


#Проект
Запустить стек
minikube start
git clone https://github.com/zorran/the-project.git
зайти в the-project
kubectl create secret generic dynamodb-seciruty --from-literal=amazon.aws.accesskey=AKIAT2UGU7XQMZAVUXY2 --from-literal=amazon.aws.secretkey=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
kubectl apply -f deployment.yml
kubectl expose deployment the-project --type=NodePort --port=8080
minikube service the-project
kubectl port-forward --address 0.0.0.0 service/the-project 7080:8080


# таблицы
create SEQUENCE carts_seq increment by 1;

create SEQUENCE products_seq increment by 1;

CREATE TABLE products (
id numeric(12,0) PRIMARY KEY NOT NULL,
name varchar(256),
cart_id numeric(12,0)
);

CREATE TABLE carts (
id numeric(12,0) PRIMARY KEY NOT NULL,
name varchar(256)
);

#aws sqs
{
"Version": "2008-10-17",
"Id": "__default_policy_ID",
"Statement": [
{
"Sid": "__owner_statement",
"Effect": "Allow",
"Principal": {
"AWS": "arn:aws:iam::263349140960:root"
},
"Action": "SQS:*",
"Resource": "arn:aws:sqs:us-east-2:263349140960:the-project-sqs"
}
]
}