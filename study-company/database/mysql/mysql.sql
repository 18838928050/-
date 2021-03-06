left join写法：
select
p.id id,
p.product_sn productSn,
p.brand_id brandId,
p.brand_name brandName,
p.product_category_id productCategoryId,
p.product_category_name productCategoryName,
p.pic pic,
p.name name,
p.sub_title subTitle,
p.price price,
p.sale sale,
p.new_status newStatus,
p.recommand_status recommandStatus,
p.stock stock,
p.promotion_type promotionType,
p.keywords keywords,
p.sort sort,
pav.id attr_id,
pav.value attr_value,
pav.product_attribute_id attr_product_attribute_id,
pa.type attr_type,
pa.name attr_name
from pms_product p
left join pms_product_attribute_value pav on p.id = pav.product_id
left join pms_product_attribute pa on pav.product_attribute_id= pa.id
where delete_status = 0 and publish_status = 1
<if test="id!=null">
            and p.id=#{id}
            </if>

--查看mysql数据库的隔离级别：
select @@tx_isolation