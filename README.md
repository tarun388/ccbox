# ccbox

Clone Dropbox

## Pre-requisites

### To start mongodb

> docker compose up -d

To close

> docker compose down

## Create public key in PEM format to sign authtokens

> cd src/main/resources

> ssh-keygen -t rsa -b 4096 -f my-public-key.pub

> ssh-keygen -f my-public-key.pub -e -m PEM > my-key-public-rsa.pem

> openssl rsa -in my-key-public-rsa.pem -pubin -RSAPublicKey_in -outform PEM -out x509_public_key.pem
