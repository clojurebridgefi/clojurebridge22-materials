This installation guide helps you to install required software for ClojureBridge.
First it guides you to install required Java SDK version, and Visual Studio Code, then set up the development environment. There are separate parts for installing the software for Mac and Windows.

# A.Install required software

# Mac OS

## Download and install Java

1. Open Spotlight (command + space), search for Terminal and open it
2. Write `java -version` command and press enter. If you see ` version "1.8.0_xxxx"`, you should be okay and you can continue to next section, installing Visual Studio Code. Otherwise continue to **3**.
3. Go to https://www.oracle.com/. You need to create an account for Oracle to be able to complete the download:
4. Click "View Accounts" from the upper right corner. Select "Create an Account" -button under Oracle Account.
5. Confirm the account in your email.
6. On Oracle page, click View Accounts from the upper right corner. Select Sign-In -button under Oracle Account, and sign in with your credentials you just made.
7. Go to https://www.oracle.com/java/technologies/downloads/ and scroll down to "Java SE Development Kit 8u341".
8. Select your operating system: macOS.
9. Click the "jdk-8u341-macosx-x64.dmg" to download the installer.
10. You need to accept the license - this version of Java is not to be used for commercial purposes. Accept, and continue with the Download -button.
11. When the download completes, open the downloaded file. Follow the installation wizard instructions.

## Install Visual Studio Code

12. Go to https://code.visualstudio.com/download and click the big blue button with "Mac" in it.
13. After the download is done, unzip the zip in your Finder.
14. Move the Visual Studio Code.app to your Applications -folder (by dragging, you might need to open another Finder-window, or by copy-pasting it).
15. When asked if you want to open Visual Studio Code because it's downloaded from the Internet, click Open.
16. Open Visual Studio Code.app from your Applications-folder.
17. Click Extensions from the left - the icon that looks like four squares with one loose, and search for Calva. The search should match "Calva: Clojure & ClojureScript Interactive Programming". Select it, and click Install.

## Install Leiningen

18. Open your Terminal again (open Spotlight (command + space), search for Terminal and open it)
19. Type "brew install leiningen". If it starts the install, you should be all set, and continue with **B. Set up VSCode** when the installation finishes.
20. If an error happened and it says it doesn't know what brew is, you might need to install Homebrew first by running this in your Terminal:
`/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)" `
After that finishes, type "brew install leiningen" again.
21. Continue with **B. Set up VSCode**.

# Windows

## Install Java

1. Open Powershell (via Start-menu search)
2. Write `java -version` command and press enter. If you see ` version "1.8.0_xxx"`, you should be okay and you can continue to next section, installing Visual Studio Code. Otherwise continue to **3**.
3. Go to https://www.oracle.com/. You need to create an account for Oracle to be able to complete the download:
4. Click "View Accounts" from the upper right corner. Select "Create an Account" -button under Oracle Account.
5. Confirm the account in your email.
6. On Oracle page, click View Accounts from the upper right corner. Select Sign-In -button under Oracle Account, and sign in with your credentials you just made.
7. Go to https://www.oracle.com/java/technologies/downloads/ and scroll down to "Java SE Development Kit 8u341".
8. Select your operating system: Windows.
9. Click the "jdk-8u341-windows-x64.exe" to download the installer.
10. You need to accept the license - this version of Java is not to be used for commercial purposes. Accept, and continue with the Download -button.
11. When the download completes, open the downloaded file. Follow the installation wizard instructions.

## Install Visual Studio Code

12. Go to https://code.visualstudio.com/download and click the big blue button with "Windows" in it.
13. Open the downloaded Code.exe, and follow the installation wizard.
14. Make sure the application opens after installation.
15. Click Extensions from the left - the icon that looks like four squares with one loose, and search for Calva. The search should match "Calva: Clojure & ClojureScript Interactive Programming". Select it, and click Install.

## Install Leiningen

16. Go to https://djpowell.github.io/leiningen-win-installer/ and download the leiningen-win-installer 1.0 under the green arrowy button. Follow the instructions of the installation wizard.
17. Continue with **B. Set up VSCode**.

If you are using Linux, you can ask help from the coach.

# B. Set up VSCode

## Get the materials

1. Go to `https://github.com/clojurebridgefi/clojurebridge22-materials`, and click the green button saying "Code". Select "Download ZIP".
2. Unzip the clojurebridge22-materials.zip
3. In Visual Studio Code, select File -> Open folder. Find the materials you just unzipped and select the "clojurebridge22-materials-main"-folder.
4. VSCode might ask for a permission to access the folder.
5. You might see a notification about whether you trust the authors of the files. Say you trust them, it's us :)

## Open the first file and start the REPL!

6. On the left you will see a project called clojurebridge. Click it open, then select src → clojurebridge → basics.clj
7. Start the repl with two key combinations: `Ctrl + Option + c` and then `Ctrl + Option + j`.
8. If you're prompted to select from two projects, select the one that ends with clojurebridge.
9. From the project type selection pick Leiningen, and then for the profiles to lauch with, just click Ok (no überjar).
10. You should see the repl on the right side, telling "Jack-in done". If not, ask for help from a coach.
