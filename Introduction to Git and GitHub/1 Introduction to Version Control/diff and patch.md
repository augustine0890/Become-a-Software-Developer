### diff
`diff` is used to find differences between two files. On its own, it's a bit hard to use; instead, use it with `diff -u` to find lines which differ in two files:

`cat menu1.txt`
`cat menu2.txt`

`diff -u menu1.txt menu2.txt`


### patch
`patch` is useful for applying file differences.
`diff -u hello_world.txt hello_world_long.txt`
`diff -u hello_world.txt hello_world_long.txt > hello_world.diff`
`patch < hello_world.diff`
