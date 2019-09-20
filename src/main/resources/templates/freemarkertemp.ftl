<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<table class="">
   <tr>
       <td>作者</td>
       <td>教程名称</td>
       <td>内容</td>
   </tr>
    <#list articles as article>
        <tr>
            <td>${article.author}</td>
            <td>${article.title}</td>
            <td>${article.content}</td>
        </tr>
    </#list>
</table>

<img src="/image/template.png"
</body>
</html>