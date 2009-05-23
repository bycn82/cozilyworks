<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!--  -->
<c:set var="protosBase" value="${pageContext.request.contextPath}/javascripts/protos" scope="request" ></c:set>
<script type='text/javascript' src="${protosBase}/prototype.js"></script>
<script type='text/javascript' src="${protosBase}/builder.js"></script>
<script type='text/javascript' src="${protosBase}/effects.js"></script>
<script type='text/javascript' src="${protosBase}/controls.js"></script>
<script type='text/javascript' src="${protosBase}/dragdrop.js"></script>
<script type='text/javascript' src="${protosBase}/slider.js"></script>
<script type='text/javascript' src="${protosBase}/validation.js"></script>
<script type='text/javascript' src="${protosBase}/niftycube.js"></script>
<script type='text/javascript' src="${protosBase}/lightbox.js"></script>
<script type='text/javascript' src="${protosBase}/ratestar.js"></script>
<script type='text/javascript' src="${protosBase}/cozlystyle.js"></script>

<!-- -->
<c:set var="ajaxURL" value="${pageContext.request.contextPath}/dwr" scope="request" />
<script type='text/javascript' src='${ajaxURL}/interface/UAS.js'></script>
<script type='text/javascript' src='${ajaxURL}/engine.js'></script>
<script type='text/javascript' src='${ajaxURL}/util.js'></script>
