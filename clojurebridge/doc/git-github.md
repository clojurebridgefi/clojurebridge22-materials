This guide is written to help you install git and set up your github account for the very first time.

If you struggle with the guide, remember to read a bit further first - or report a bug if you find one! :-)



# Create a GitHub account

Go to https://github.com/ and sign up. Use any email you wish to. Follow the account creating process.
When you see yourself signed in on the GitHub page, you're done!


# Install git on your computer

## Mac OS

Assuming you have Homebrew installed (if you and the computer attended ClojureBridge on 2022, you should have it), just open your Terminal, and type `brew install git`.
You can verify the installation by typing `git --version`.

After installation, you need to configure git to work smoothly.
Type these into your Terminal, and be sure to use the same email you used when creating GitHub account:

`git config --global user.name "replaceThisWithYourOwnUserName"`

`git config --global user.email "replaceThisWithYourOwnEmail"`

In case of typo or other weirdness, you can run those commands again, and the last one will stay.
You can check the configuratins by typing `git config --list`.

## Windows

Go to https://git-scm.com/download/win and click the link right on the top of the screen: "Click here to download".

After the package is downloaded, open it and follow the installer instructions.
When the installer asks for the editor to be used with Git, you can pick what ever you wish, but as we have been using Visual Studio Code, that is a familiar choice. Otherwise continue with the recommended settings. After the installation completes, launch Git Bash.

In the Git Bash terminal, you can verify the installation by typing `git version`.

After installation, you need to configure git to work smoothly.
Type these into your Git Bash terminal, and be sure to use the same email you used when creating GitHub account:

`git config --global user.name "replaceThisWithYourOwnUserName"`

`git config --global user.email "replaceThisWithYourOwnEmail"`

In case of typo or other weirdness, you can run those commands again, and the last one will stay.
You can check the configuratins by typing `git config --list`.
