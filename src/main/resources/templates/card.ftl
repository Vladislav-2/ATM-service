<#import "parts/pageTemplate.ftl" as pt>
<@pt.page>

    <#import "parts/pager.ftl" as p>

    <@p.pager url page/>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">CardUser</th>
        <th scope="col">CardNumber</th>
        <#--<th scope="col">CreatedDate</th>-->
        <#--<th scope="col">UpdatedDate</th>-->
        <th scope="col">UsageTime</th>
        <th scope="col">Cash</th>
        <th scope="col">isBlocked</th>
        <th scope="col">is Deleted</th>
        <th scope="col">Edit</th>
        <th scope="col">To Block/ Un Block</th>
        <th scope="col">Remove/Reaper</th>
    </tr>
    </thead>
    <tbody>
     <#list page.content as card>

     <tr>
            <#if card.id??>
                <th scope="row">${card.id}</th></#if>
            <#if card.cardUser??>
                <td>${card.cardUser}</td></#if>
            <#if card.cardNumder??>
                <td>${card.cardNumder}</td></#if>
            <#if card.createdDate??>
                <td>${card.createdDate}</td></#if>
            <#if card.updatedDate??>
                <td>${card.updatedDate}</td></#if>
            <#if card.usageTime??>
                <td>${card.usageTime}</td></#if>
            <#if card.cash??>
                <td>${card.cash}</td></#if>
            <#if card.isBlocked??>
                <td>${card.isBlockedString()}</td></#if>
            <#if card.deleted??>
                <td>${card.deleted?then("true","false")}</td></#if>

         <td scope="row">${card.deleted?then(
         '<div href="card?reaper=${card.id}"  class="btn btn-secondary">edit</div>',
         '<a href="card?edit=${card.id}"  class="btn btn-info">edit</a>')
         }
         </td>

         <td>${card.isBlocked()?then(
         '<a href="card?unBlock=${card.id}"  class="btn btn-outline-warning">block</a>',
         '<a href="card?block=${card.id}"  class="btn btn-outline-warning">block</a>')
         }
         </td>

         <td>${card.deleted?then(
         '<a href="card?reaper=${card.id}"  class="btn btn-outline-danger">reaper</a>',
         '<a href="card?remove=${card.id}"  class="btn btn-outline-danger">remove</a>')
         }
         </td>

     </tr>
     <#else>
        <td colspan="5" style="text-align:center">Cars lst is Empty</td>

     </#list>
    </tbody>
</table>
    <@p.pager url page/>

<h3>Edit card</h3>
    <#if savingReport??><div class="alert alert-danger" role="alert">${savingReport}</div></#if>

<div class="form-group mt-3">
    <form method="post">

        <input type="hidden" name="id" value="<#if card?? && card.id??>${card.id}</#if>">

        <div class="form-group">
            <input type="number" name="pin"
                   class="form-control ${(pinError??)?string('is-invalid', '')}"
                   value="<#if card??>${card.pin}</#if>" placeholder="Enter the pin">
            <#if pinError??>
                <div class="invalid-feedback">
                    ${pinError}
                </div>
            </#if>
        </div>
        <div class="form-group">
            <input type="text" name="cardUser"
                   class="form-control ${(cardUserError??)?string('is-invalid', '')}"
                   value="<#if card??>${card.cardUser}</#if>" placeholder="Enter the name of card user">
            <#if cardUserError??>
                <div class="invalid-feedback">
                    ${cardUserError}
                </div>
            </#if>
        </div>
        <div class="form-group">
            <input type="text" name="cardNumder"
                   class="form-control ${(cardNumderError??)?string('is-invalid', '')}"
                   value="<#if card??>${card.cardNumder}</#if>" placeholder="Enter the number of card">
            <#if cardNumderError??>
                <div class="invalid-feedback">
                    ${cardNumderError}
                </div>
            </#if>
        </div>
        <div class="form-group">
            <input type="date" name="usageTime"
                   class="form-control ${(usageTimeError??)?string('is-invalid', '')}"
                   value="<#if card?? && card.usageTime??>${card.usageTime}</#if>" placeholder="Enter the usageTime">
            <#if usageTimeError??>
                <div class="invalid-feedback">
                    ${usageTimeError}
                </div>
            </#if>
        </div>
        <div class="form-group">
            <input type="number" name="cash"
                   class="form-control ${(cashError??)?string('is-invalid', '')}"
                   value="<#if card?? && card.cash??>${card.cash}</#if> " placeholder="Enter the cash">
            <#if cashError??>
                <div class="invalid-feedback">
                    ${cashError}
                </div>
            </#if>
        </div>

        <div class="form-group mt-2">
            <button type="submit" class="btn btn-primary">
                <#if !card??>
                    Create
                <#else>
                    Update
                </#if>
            </button>
        </div>
    </form>
</div>

</@pt.page>