<%@ tag body-content="empty" pageEncoding="UTF-8" %>
<%@ attribute name="pagination" required="true" type="com.jongo.util.Pagination" %>
<%@ attribute name="urlPattern" required="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="pagePlaceHolder" value="_page_"/>
<div class="pagination">
	<span style="margin-left:100px;margin-right:100px">
	Listing&nbsp; ${pagination.firstRow}-${pagination.lastRow}&nbsp; of&nbsp; ${pagination.totalRecords}
	</span>
	<span>
		<span class="previous_page">
		<c:if test="${pagination.page > 1}"><a href="${fn:replace(urlPattern, pagePlaceHolder, pagination.previousPage)}"></c:if>Prev<c:if test="${pagination.page > 1}"></a></c:if>
		</span> 
		<span> 
		<strong>Page:${pagination.page} of ${pagination.pageNumber}</strong>
		</span> 
		<span class="next_page"> 
		<c:if test="${pagination.page < pagination.pageNumber}"><a href="${fn:replace(urlPattern, pagePlaceHolder, pagination.nextPage)}"></c:if>Next<c:if test="${pagination.page < pagination.pageNumber}"></a></c:if>
		</span>
		<span class="goto"> 
		Goto:
		<select onchange="window.location.href=this.options[this.selectedIndex].value;">
		<c:forEach var="i" begin="1" end="${pagination.pageNumber}">
		<option value="${fn:replace(urlPattern, pagePlaceHolder, i)}" ${i == page ? 'selected' : '' }>${i}</option>
		</c:forEach>
		</select>
		</span>	
	</span>
</div>