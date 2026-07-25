\# Hands-On 2: .gitignore



\## Objective

Ignore unwanted files/folders (log files) from being tracked by Git.



\## Steps Performed



1\. Created a dummy log file `app.log` and a folder `logs/` containing

&#x20;  `debug.log`, simulating build/runtime artifacts.

2\. Created `.gitignore` with:

\*.log

logs/



3\. Verified with `git status --untracked-files=all` that `app.log` and

`logs/debug.log` do NOT appear in the untracked files list, confirming

they are correctly ignored.



\## Output (git status --untracked-files=all)

Untracked files:

.gitignore



(app.log and logs/debug.log are absent — successfully ignored)

