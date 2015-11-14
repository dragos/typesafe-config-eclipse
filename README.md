# Eclipse plugin for Typesafe Config files

This project provides Eclipse toolings for editing configuration files in Hocon format (coloquially called [Typesafe Config](https://github.com/typesafehub/config)).

# Installation

Eclipse Marketplace:

Update site: https://dl.bintray.com/dragos/typesafe-config-eclipse/

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

The project is based on [xtext](https://www.eclipse.org/Xtext/index.html). Help in the form of code contributions are very welcome!