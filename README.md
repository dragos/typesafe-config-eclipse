# Eclipse plugin for Typesafe Config files

This project provides Eclipse toolings for editing configuration files in Hocon format (coloquially called [Typesafe Config](https://github.com/typesafehub/config)).

# Installation

### Eclipse Marketplace:
<a href="http://marketplace.eclipse.org/marketplace-client-intro?mpc_install=2607663" class="drag" title="Drag to your running Eclipse workspace to install Typesafe Config SDK"><img src="https://marketplace.eclipse.org/sites/all/themes/solstice/_themes/solstice_marketplace/public/images/btn-install.png" alt="Drag to your running Eclipse workspace to install Typesafe Config SDK" /></a> Drag the install button on your running Eclipse application

### Update site
Alternatively, use the plain old update site: https://dl.bintray.com/dragos/typesafe-config-eclipse/

# Features

- configurable syntax highlighting and error checking
- outline view
- auto edits, match braces

![Screenshot](/images/screenshot.png?raw=true)

# Limitations

- no support for substitutions
- no completion or hyperlinking

# Build

Run `mvn` inside `com.typesafe.hocon.releng`.

# Contribute

The project is based on [xtext](https://www.eclipse.org/Xtext/index.html). Help in the form of code contributions is most welcome!