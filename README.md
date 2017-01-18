[![Build Status](https://travis-ci.org/dragos/typesafe-config-eclipse.svg?branch=master)](https://travis-ci.org/dragos/typesafe-config-eclipse)
[ ![Download](https://api.bintray.com/packages/dragos/typesafe-config-eclipse/typesafe-config-eclipse/images/download.svg) ](https://bintray.com/dragos/typesafe-config-eclipse/typesafe-config-eclipse/_latestVersion)

# Eclipse plugin for Typesafe Config files

This project provides Eclipse toolings for editing configuration files in Hocon format (coloquially called [Typesafe Config](https://github.com/typesafehub/config)).

# Installation

### Eclipse Marketplace:
<a href="http://marketplace.eclipse.org/marketplace-client-intro?mpc_install=2607663" class="drag" title="Drag to your running Eclipse workspace."><img class="img-responsive" src="https://marketplace.eclipse.org/sites/all/themes/solstice/public/images/marketplace/btn-install.png" alt="Drag to your running Eclipse workspace." /></a>
Drag the install button on your running Eclipse application

### Update site
Alternatively, use the plain old update site: https://dl.bintray.com/dragos/typesafe-config-eclipse/

# Features

- configurable syntax highlighting and error checking
- outline view
- toggle comments
- structured selection (syntax-aware increase/decrease selection)
- auto edits, match braces

![Screenshot](/images/screenshot.png?raw=true)

# Limitations

- no completion or hyperlinking

# Build

Run `mvn` inside `com.typesafe.hocon.releng`.

# Cut a release

- check that the current version is correct (1 ahead of the latest release)
- build release
- `./publish.sh <BintrayAPIkey> <version>`, where `<version>` is a non-SNAPSHOT version.
Say, the current version in `pom.xml` is `1.0.5-SNAPSHOT`, you should call `./publish.sh` with `1.0.5`
- tag (e.g. (`git tag v1.0.5`) and push tags
- bump version (inside `com.typesafe.hocon.releng`): `mvn org.eclipse.tycho:tycho-versions-plugin:set-version -DnewVersion=1.0.6-SNAPSHOT`

# Contribute

The project is based on [xtext](https://www.eclipse.org/Xtext/index.html). Help in the form of code contributions is most welcome!
