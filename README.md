<div id="top"></div>

<!-- PROJECT HEADER -->
<br />
<div align="center">
  <a href="https://github.com/ModdedMCStudios/Standard/graphs/contributors">
    <img src="https://img.shields.io/github/contributors/ModdedMCStudios/Standard.svg?style=for-the-badge" alt="Logo">
  </a>
  <a href="https://github.com/ModdedMCStudios/Standard/network/members">
    <img src="https://img.shields.io/github/forks/ModdedMCStudios/Standard.svg?style=for-the-badge" alt="Logo">
  </a>
  <a href="https://discord.gg/fTZSX9Y7uz">
    <img src="https://img.shields.io/discord/752614300413329510.svg?style=for-the-badge&logo=discord&logoColor=white" alt="Logo">
  </a>
  <a href="https://github.com/ModdedMCStudios/Standard/stargazers">
    <img src="https://img.shields.io/github/stars/ModdedMCStudios/Standard.svg?style=for-the-badge" alt="Logo">
  </a>
  <a href="https://github.com/ModdedMCStudios/Standard/blob/main/LICENSE">
    <img src="https://img.shields.io/github/license/ModdedMCStudios/Standard.svg?style=for-the-badge" alt="Logo">
  </a>
  <br />
  <br />
  <a href="https://github.com/ModdedMCStudios/Standard">
    <img src=".github/logo.png" alt="Logo" width="600">
  </a>
<h3 align="center">Standard StdLib</h3>
  <p align="center">
    A exhaustive standard library for Minecraft mod development.
    <br />
    <a href="https://github.com/ModdedMCStudios/Standard"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/ModdedMCStudios/Standard/issues">Report Bug</a>
    ·
    <a href="https://github.com/ModdedMCStudios/Standard/issues">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

Standard Library is a collection of utilities, features, and additions aimed at improving development workflow
and allow devs to spend more time creating features than complicated backend logic.

<!-- GETTING STARTED -->
## Getting Started

### Prerequisites 

Before installing Standard you should have a functioning Fabric workspace for the target minecraft version already.

### Installation

To include Standard libraries in your mod add the following to the `dependencies` in your buildscript.

And add the maven `https://maven.modded-mc.com/repository/maven-public` to your `repositories`

#### Groovy DSL

```groovy
platform "com.moddedmc.std:bom:$STD_LIB_VERSION"

modImplementation "com.moddedmc.std:std-lib"
modImplementation "com.moddedmc.std:std-resources"
// etc
```
#### Kotlin DSL
```kotlin
platform("com.moddedmc.std:bom:$STD_LIB_VERSION")

modImplementation("com.moddedmc.std:std-lib")
modImplementation("com.moddedmc.std:std-resources")
// etc
```

<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/new-feature`)
3. Commit your Changes (`git commit -m 'Add some new feature'`)
4. Push to the Branch (`git push origin feature/new-feature`)
5. Open a Pull Request

<!-- LICENSE -->
## License

Distributed under the LGPL 3.0 License. See `LICENSE` for more information.

<!-- CONTACT -->
## Contact

To talk to the team head over to our [Discord](https://discord.gg/fTZSX9Y7uz)

<p align="right">(<a href="#top">back to top</a>)</p>