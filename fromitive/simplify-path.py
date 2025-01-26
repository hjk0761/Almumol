"""
title : Simplify Path
link  : https://leetcode.com/problems/simplify-path

description
Unix 경로 문자열이 주어졌을때 이를 가공하는 코드를 작성해야 한다.
각 경로는 "/"로 구분되어 있으며 이름이 ".." 일경우 상위 디렉터리 경로를 표현한다. 예를 들어 "/user/etc/.." 이면 가공된 경로는 "/user" 이다. 
디렉터리 및 파일 명이 "..."일 경우는 일단 경로와 똑같이 처리되어야 한다.
경로명이 비어있거나 ("//" 와 같은 형태) "." 일 경우 현재 디렉터리로 구분된다. 예를 들어 "/user//etc/.//" 이면 가공된 경로는 "/user/etc" 이다.
"""

class Solution:
    def simplifyPath(self, path: str) -> str:
        stack = []
        for name in path.split("/"):
            if name == "." or name == "":
                continue
            elif name == "..":
                if len(stack) != 0:
                    stack.pop()
            else:
                stack.append(name)
        return "/" + "/".join(stack)