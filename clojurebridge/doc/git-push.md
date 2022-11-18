This guide is a simplified guide to help you push the code we wrote in ClojureBridge2 to your own GitHub!
It assumes you already have Git installed and GitHub account created.

If you struggle with the guide, remember to read a bit further first - or report a bug if you find one! :-)


# Create a new SSH key pair, for GitHub.

## Mac OS

Enter the following command in the Terminal.

`ssh-keygen -t rsa`

It should ask a location, just accept it by pressing Enter.
It also asks a passphrase. You can create a passphrase here or just skip it by pressing Enter. If you create a passphrase, you might need to give it again.

After the creation is done, you can copy the puclib key to your clipboard with this command:

`pbcopy < ~/.ssh/id_rsa.pub`

## Windows

Enter the following command in the Command Prompt.

`ssh-keygen -t ed25519`

It should ask a location, just accept it by pressing Enter.
It also asks a passphrase. You can create a passphrase here or just skip it by pressing Enter. If you create a passphrase, you might need to give it again.

After the creation is done, you can copy the puclib key to your clipboard with this command:

`clip < ~/.ssh/id_rsa.pub`

# Set up SSH-keys between GitHub and your computer

Go to https://github.com/ and sign in with your account.
Navigate under your profile (upper right corner) and select Settings from the dropdown menu.
On the left, select the `SSH and GPG keys`.
Click "New SSH Key".

Give the new key a title. The key is between your current computer and the GitHub account, nothing else.
Leave the Key type as Authentication Key.
In the Key -field, paste the puclib key you copied into your clipboard.
Click the `Add SSH key` -button to finalize process.


# Create a GitHub repository and push the codes into GitHub

Open your Terminal or other command promps, and go to the project folder. Make sure you are in the right place by typing `git status`.
Because we did the first commit in the ClojureBridge workshop, it should tell you something like
"Your branch is ahead of 'origin/main' by 1 commit.
  (use "git push" to publish your local commits)"


In the GitHub, navigate to Repositories, and create a new one. The name doesn't matter, but it's nice to be descriptive.

Give your repository an name, and select if you wish it to be public or private.
Leave the rest of the selections as it - we already had a Readme -file in our project so we don't need to create a new one.
Click "Create repository"

In the Quick setup -phase, make sure you have SSH selected from the switch, and not HTTPS.


Under the "…or push an existing repository from the command line", give those commands one by one in your Terminal.
