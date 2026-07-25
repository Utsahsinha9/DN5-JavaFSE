\# Hands-On 3: Branching \& Merging



\## Objective

Create a branch, make changes on it, merge it back into master, and

observe the commit graph.



\## Steps Performed



1\. Created `main-file.txt` with content, committed on `main`.

2\. Created branch `GitNewBranch` and switched to it (`git checkout GitNewBranch`).

3\. Added `branch-file.txt` with content, committed on the branch.

4\. Switched back to `main`, ran `git diff main GitNewBranch` — confirmed

&#x20;  the diff showed `branch-file.txt` as new.

5\. Merged with `git merge GitNewBranch` — resolved as a \*\*fast-forward

&#x20;  merge\*\* (since master had no divergent commits since the branch was created).

6\. Verified merge via `git log --oneline --graph --decorate` — history

&#x20;  shows a single linear line including both commits.

7\. Deleted the branch with `git branch -d GitNewBranch` and confirmed

&#x20;  `git status` shows a clean working tree.



\## Notes

Since `main` didn't move after the branch was created, Git performed a

fast-forward merge rather than creating a merge commit. This is expected

Git behavior and confirms the branch's commit was correctly reachable

from `main` afterward.

