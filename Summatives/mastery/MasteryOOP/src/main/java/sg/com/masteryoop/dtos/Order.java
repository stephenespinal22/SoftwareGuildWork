/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.masteryoop.dtos;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * An order consists of an order number, customer name, state, tax rate, product type , area, cost
 * per square foot, labor cost per square foot, material cost, labor cost, tax, and total.
 *
 * plan is to keep track of a counter on how many orders have been made to keep unique order number
 * this will be in the service layer and
 *
 * @author stephenespinal
 */
public class Order {

    private int orderId;
    private String customerName;
    private String state;
    private BigDecimal taxRate;
    private String productType;
    private BigDecimal area;
    private BigDecimal costSqft;
    private BigDecimal laborCostSqft;
    private BigDecimal materialCost;
    private BigDecimal laborCost;
    private BigDecimal tax;
    private BigDecimal total;

    public Order(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getCostSqft() {
        return costSqft;
    }

    public void setCostSqft(BigDecimal costSqft) {
        this.costSqft = costSqft;
    }

    public BigDecimal getLaborCostSqft() {
        return laborCostSqft;
    }

    public void setLaborCostSqft(BigDecimal laborCostSqft) {
        this.laborCostSqft = laborCostSqft;
    }

    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost;
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public int getOrderId() {
        return orderId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.orderId;
        hash = 43 * hash + Objects.hashCode(this.customerName);
        hash = 43 * hash + Objects.hashCode(this.state);
        hash = 43 * hash + Objects.hashCode(this.taxRate);
        hash = 43 * hash + Objects.hashCode(this.productType);
        hash = 43 * hash + Objects.hashCode(this.area);
        hash = 43 * hash + Objects.hashCode(this.costSqft);
        hash = 43 * hash + Objects.hashCode(this.laborCostSqft);
        hash = 43 * hash + Objects.hashCode(this.materialCost);
        hash = 43 * hash + Objects.hashCode(this.laborCost);
        hash = 43 * hash + Objects.hashCode(this.tax);
        hash = 43 * hash + Objects.hashCode(this.total);
        return hash;
    }

    @Override
    public String toString() {
        return "Order Number: " + orderId + "\nCustomer Name: " + customerName + "\nState: " + state
                + "\nTax Rate: " + taxRate + "\nProduct Type: " + productType
                + "\nArea (Sqft): " + area + "\nCost (Sqft): $" + costSqft + "\nLabor Cost (Sqft): $"
                + laborCostSqft + "\nMaterial Cost: $" + materialCost
                + "\nLabor Cost: $" + laborCost + "\nTax: $" + tax + "\nTotal: $" + total;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (this.orderId != other.orderId) {
            return false;
        }
        if (!Objects.equals(this.customerName, other.customerName)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.productType, other.productType)) {
            return false;
        }
        if (!Objects.equals(this.taxRate, other.taxRate)) {
            return false;
        }
        if (!Objects.equals(this.area, other.area)) {
            return false;
        }
        if (!Objects.equals(this.costSqft, other.costSqft)) {
            return false;
        }
        if (!Objects.equals(this.laborCostSqft, other.laborCostSqft)) {
            return false;
        }
        if (!Objects.equals(this.materialCost, other.materialCost)) {
            return false;
        }
        if (!Objects.equals(this.laborCost, other.laborCost)) {
            return false;
        }
        if (!Objects.equals(this.tax, other.tax)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        return true;
    }

}
