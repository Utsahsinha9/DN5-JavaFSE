\# Hands-On 5: Cleanup \& Push



\## Objective

Verify a clean working state, pull the latest remote changes, and

confirm all local work is pushed and reflected on the remote.



\## Steps Performed



1\. Ran `git status` — confirmed working tree was clean and branch was

&#x20;  up to date with origin/main.

2\. Ran `git pull` — confirmed already up to date (no remote changes to

&#x20;  merge).

3\. Ran `git branch -a` — reviewed local vs remote branches, found the

&#x20;  leftover `GitWork` branch from the conflict-resolution exercise

&#x20;  (already merged into main).

4\. Deleted the merged branch: `git branch -d GitWork` — succeeded

&#x20;  cleanly since it was fully merged, no `-D` force-delete needed.

5\. Also found and removed a stray untracked file (`tatus`) accidentally

&#x20;  created in the repo root from a mistyped command earlier — confirmed

&#x20;  `git status` was clean afterward.



\## Verification

\- `git branch -a` after cleanup shows only `main` locally, matching

&#x20; `origin/main`.

\- Repository is in a clean, fully-pushed state with no dangling branches

&#x20; or untracked files.

