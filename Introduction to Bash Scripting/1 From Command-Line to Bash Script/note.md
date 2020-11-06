### From Command-Line to Bash Script
**Shell commands refresher**
- Some important shell commands:
    - `(e)grep` filters input based on regex pattern matching
    - `cat` concatenates file contents line-by-line
    - `tail` \ `head` give only the last `-n` (a flag) lines
    - `wc` does a word or line count (with flags `-w` `-l`)
    - `sed` does pattern-matched string replacement

`sort | uniq -c`
    - The first will sort alphabetically, the second will do a count
    - If we wanted the top _n_ we could then pipe to `wc -l` and use `head`
    `cat filename.txt | sort | uniq -c | head -n 3`
    `14 apple`
    `13 bannana`
    `12 carrot`