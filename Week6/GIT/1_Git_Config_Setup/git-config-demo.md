\# Hands-On 1: Git Configuration Setup



\## Objective

Set up Git on a local machine, configure user identity, and set a

default editor for Git operations.



\## Steps Performed



\### 1. Verified Git installation

Command: `git --version`

Output: `git version 2.54.0.windows.1`



\### 2. Verified global user configuration

Commands:

git config --global user.name

git config --global user.email



Output:

Utsah Sinha

utsah9@gmail.com



\### 3. Set default Git editor

Command:

git config --global core.editor "code --wait"



This sets Visual Studio Code as the default editor for Git operations

such as commit message editing and interactive rebase, replacing the

original lab's notepad++ setup.



\## Notes

Adapted from the original Git-HOL exercise (which targeted GitLab +

notepad++) to this project's actual workflow: GitHub + VS Code.

