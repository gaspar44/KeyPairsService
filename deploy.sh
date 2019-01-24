#!/bin/bash

if [ "$TRAVIS_BRANCH" = 'master' ]; then
	openssl aes-256-cbc -K $encrypted_9558564ad590_key -iv $encrypted_9558564ad590_iv -in secret.gpg.enc -out secret.gpg -d
	gradle clean uploadArchvies -PossrhUsername=${SONATYPE_USERNAME} -PossrhPassword=${SONATYPE_PASSWORD} -Psigning.keyId=${GPG_KEY_ID} -Psigning.password=${GPG_KEY_PASSPHRASE} -Psigning.secretKeyRingFile=secret.gpg
fi