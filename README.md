---
title: 电商秒杀系统
tags: 电商，秒杀系统,MARKDOWN,帮助
slug: storywriter/grammar
grammar_abbr: true
grammar_table: true
grammar_defList: true
grammar_emoji: true
grammar_footnote: true
grammar_ins: true
grammar_mark: true
grammar_sub: true
grammar_sup: true
grammar_checkbox: true
grammar_mathjax: true
grammar_flow: true
grammar_sequence: true
grammar_plot: true
grammar_code: true
grammar_highlight: true
grammar_html: true
grammar_linkify: true
grammar_typographer: true
grammar_video: true
grammar_audio: true
grammar_attachment: true
grammar_mermaid: true
grammar_classy: true
grammar_cjkEmphasis: true
grammar_cjkRuby: true
grammar_center: true
grammar_align: true
grammar_tableExtra: true
--- 

[toc!?theme=gray&depth=4]

# eckill 电子直播-秒杀系统

## 1.1 涉及到的知识
- VUE全家桶(前端开发)
- SpringBoot、Spring、SpringMVC、Mybatis 后台开发
- MySQL、Redis

## 1.2 当前进度
- 功能：登录页、登陆功能

## 1.3 安全优化部分
- 隐藏秒杀地址
```markdown
思路：秒杀开始前，先去请求接口获取秒杀地址

1.接口改造，带上PathVariable参数

2.添加生成地址的接口

3.秒杀收到请求，先验证PathVariable
```

 - 数学公式验证码
```markdown
1.添加生产验证码接口

2.在获取秒杀路径的时候，验证验证码

3.ScriptEngine使用
```