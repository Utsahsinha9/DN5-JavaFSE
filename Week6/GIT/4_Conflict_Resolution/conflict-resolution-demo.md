\# Hands-On 4: Conflict Resolution



\## Objective

Simulate and resolve a merge conflict where the same file is modified

differently on two branches.



\## Steps Performed



1\. Committed `hello.xml` with original content on `main`.

2\. Created branch `GitWork`, modified `hello.xml` there, committed.

3\. Switched back to `main`, modified the same file differently, committed —

&#x20;  this creates diverging history on the same file.

4\. Ran `git merge GitWork` — Git reported a conflict:

&#x20;  `CONFLICT (content): Merge conflict in hello.xml`



\## Lesson learned: binary vs text conflict

PowerShell's `Out-File` defaults to UTF-16 encoding, which Git's diff

engine treats as \*\*binary\*\*, not text. Because of this, Git could not

show inline `<<<<<<<` / `=======` / `>>>>>>>` conflict markers — it just

flagged the file as conflicted (`Cannot merge binary files`).



\## Resolution

Rewrote `hello.xml` with UTF-8 encoding (`-Encoding utf8`) containing

the resolved content, then:

git add hello.xml

git commit -m "Week6: Ex4 - resolve merge conflict in hello.xml"



This created a true merge commit (not a fast-forward), visible in

`git log --oneline --graph --decorate` as two diverging branches

joining back into `main`.



\## Takeaway

In real projects, source files (Java, XML, etc.) are saved as UTF-8 by

editors like VS Code, so this binary-detection issue is specific to how

PowerShell's `Out-File` writes text — worth knowing when scripting file

changes for Git exercises on Windows.

