<%@page contentType="text/html" pageEncoding="UTF-8"%>
<navbar :current="currentNav" :link="false"></navbar>
<div id="main">
  <router-view></router-view>
</div>