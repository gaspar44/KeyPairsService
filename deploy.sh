#!/bin/bash
if [[ "$TRAVIS_BRANCH" = 'master' ]]; then
	sed -i "s/REPLACE_BY_RELEASE/${release}/g" gradle.properties
	sed -i "s/REPLACE_BY_SONATYPE_USERNAME/${SONATYPE_USERNAME}/g" gradle.properties
	sed -i "s/REPLACE_BY_SONATYPE_PASSWORD/${SONATYPE_PASSWORD}/g" gradle.properties
	sed -i "s/REPLACE_BY_GPG_KEY_ID/${GPG_KEY_ID}/g" gradle.properties
	sed -i "s/REPLACE_BY_GPG_KEY_PASSPHRASE/${GPG_KEY_PASSPHRASE}/g" gradle.properties
	
	gradle clean uploadArchives
fi
