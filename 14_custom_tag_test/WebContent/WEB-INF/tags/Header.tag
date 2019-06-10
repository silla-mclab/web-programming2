<%@ tag body-content="tagdependent" %>
<%@ attribute name="fontColor" required="false" rtexprvalue="true" %>
<%@ attribute name="subTitle" required="true" rtexprvalue="true" %>
<img src="${pageContext.request.contextPath}/resources/web_service.jpg"> <br>
<p><em><strong>${subTitle}</strong></em></p>
<dir style="color: ${fontColor};"><em><strong><jsp:doBody /></strong></em></dir>