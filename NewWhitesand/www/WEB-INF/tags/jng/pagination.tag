<%@ tag body-content="empty" pageEncoding="UTF-8" %>
<%@ attribute name="pagination" required="true" type="com.jongo.util.Pagination" %>
<%@ attribute name="urlPattern" required="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="pagePlaceHolder" value="_page_"/>
<div class="pagenum">
<form action="">

${pagination.firstRow}-${pagination.lastRow}&nbsp; of&nbsp; ${pagination.totalRecords}
&nbsp;
Total: ${pagination.pageNumber} ${pagination.pageNumber > 1 ? 'pages' : 'page'} 
&nbsp;

<a href="${fn:replace(urlPattern, pagePlaceHolder, 1)}" title="Go to the first page">&lt;&lt;</a>

<c:if test="${pagination.page > 1}">
	<a href="${fn:replace(urlPattern, pagePlaceHolder, pagination.previousPage)}" title="Previous page">&lt;</a>
</c:if>

<c:choose>
	<c:when test="${pagination.pageNumber < 5 || pagination.page <5}">
		<c:forEach var="pos" begin="1" end="${(pagination.pageNumber >5)?5:pagination.pageNumber}" >
			<c:set var="page" value="${pos}"/>
			<c:if test="${page <= pagination.pageNumber}">
				<a href="${fn:replace(urlPattern, pagePlaceHolder, page)}"  ${page == pagination.page ? 'class="on"' : ''} title="page${page}">${page}</a>
			</c:if>
		</c:forEach>
	</c:when>
	<c:otherwise>
		<c:choose>
			<c:when test="${pagination.page==pagination.pageNumber}">
				<c:forEach var="pos" begin="1" end="${pagination.numbersPerBlock}" >
					<c:set var="page" value="${pagination.page-pagination.numbersPerBlock+pos}"/>
					<c:if test="${page <= pagination.pageNumber}">
						<a href="${fn:replace(urlPattern, pagePlaceHolder, page)}"  ${page == pagination.page ? 'class="on"' : ''} title="page${page}">${page}</a>
					</c:if>
				</c:forEach>
			
			</c:when>
			<c:otherwise>
				<c:forEach var="pos" begin="1" end="${pagination.numbersPerBlock}" >
					<c:set var="page" value="${pagination.page-pagination.numbersPerBlock+pos+1}"/>
					<c:if test="${page <= pagination.pageNumber}">
						<a href="${fn:replace(urlPattern, pagePlaceHolder, page)}"  ${page == pagination.page ? 'class="on"' : ''} title="page${page}">${page}</a>
					</c:if>
				</c:forEach>
			</c:otherwise>
		</c:choose>		
	</c:otherwise>
</c:choose>

	
<c:if test="${pagination.page < pagination.pageNumber}">
	<a href="${fn:replace(urlPattern, pagePlaceHolder, pagination.nextPage)}" title="Next page">&gt;</a>
</c:if>

<a href="${fn:replace(urlPattern, pagePlaceHolder, pagination.pageNumber)}" title="Go to the last page">&gt;&gt;</a>

&nbsp;&nbsp;&nbsp;Go To&nbsp;

<input name="page" type="text" class="Ipt" value="${pagenation.nextPage}" size="2"/>

<input type="image" name="btnGo" 
	src="${pageContext.request.contextPath}/images/common/go_btn.gif" 
	onclick="window.location.href='${urlPattern}'.replace('${pagePlaceHolder}',this.form.page.value);return false;"/>&nbsp;

</form>
</div>