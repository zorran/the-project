# the-project

docker build --tag the-project .

docker save -o ./the-project.tar the-project

scp -i /d/AWS/k.shnyrkov.pem ./the-project.tar ec2-user@ec2-3-133-139-186.us-east-2.compute.amazonaws.com:/home/ec2-user/the-project.tar

docker load -i ./the-project.tar

docker run -i -t --rm -d -p 8080:8080 the-project /bin/bash

