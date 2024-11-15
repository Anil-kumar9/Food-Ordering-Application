import {
  Component,
  Input,
  NgZone,
  OnChanges,
  SimpleChanges,
} from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
// import * as Razorpay from 'razorpay';

import { FoodCart } from 'src/app/models/food-cart';
import { Order } from 'src/app/models/order';
import { OrderItem } from 'src/app/models/order-item';
import { User } from 'src/app/models/user';
import { UserAddress } from 'src/app/models/user-address';
import { CartService } from 'src/app/services/cart.service';
import { OrderService } from 'src/app/services/order.service';
import { RestaurantService } from 'src/app/services/restaurant.service';
import { UserService } from 'src/app/services/user.service';
import { SelectAddressComponent } from '../select-address/select-address.component';

declare var Razorpay: any;

@Component({
  selector: 'app-place-order',
  templateUrl: './place-order.component.html',
  styleUrls: ['./place-order.component.css'],
})
export class PlaceOrderComponent implements OnChanges {
  email: string;

  addresses: UserAddress[] = [];
  defaultAddress: UserAddress = {} as UserAddress;
  selectedAddress: number = 0;
  orderItems: OrderItem[] = [];
  order: Order = {} as Order;
  user: User = {} as User;
  imageLink: string =
    'data:image/png;base64,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';

  @Input() totalCost: number = 0;
  @Input() combinedFoodCart: FoodCart[] = [];

  finalCost: number = 0;
  foodCart: FoodCart[] = [];

  constructor(
    private userService: UserService,
    private dialog: MatDialog,
    private orderService: OrderService,
    private cartService: CartService,
    private router: Router,
    private ngZone: NgZone
  ) {
    const email = sessionStorage.getItem('email');
    this.email = email === null ? '' : email;

    this.userService.getAddressByEmail(this.email).subscribe((data) => {
      this.addresses = data;
      this.defaultAddress = this.addresses[this.selectedAddress];
    });

    this.userService.getUserByEmail(this.email).subscribe((data) => {
      this.user = data;
    });

    console.log(this.totalCost);
  }

  ngOnChanges(changes: SimpleChanges) {
    if (changes['totalCost']) {
      this.finalCost = this.totalCost;
    }
    if (changes['combinedFoodCart']) {
      this.foodCart = this.combinedFoodCart;
    }
  }

  openSelectAddressDialog() {
    const dialogRef = this.dialog.open(SelectAddressComponent, {
      data: {
        addresses: this.addresses,
        selectedAddress: this.selectedAddress,
      },
    });

    dialogRef.afterClosed().subscribe((result) => {
      this.selectedAddress = result;
      this.defaultAddress = this.addresses[this.selectedAddress];
    });
  }

  onOrder() {
    this.orderService.createTransaction(this.totalCost).subscribe(
      (data) => {
        this.openTransactionModel(data);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  openTransactionModel(response: any) {
    console.log(response)
    var options = {
      order_id: response.orderId,
     key: response.key,
      amount: response.amount,
      currency: response.currency,
      name: 'Foody',
      description: 'Payment of your online order',
      image: this.imageLink,
      handler: (response: any) => {
        if (response !== null && response.razorpay_payment_id !== null) {
          this.placeOrder(response);
        } else {
          console.log('Payment Failed');
        }
      },
      prefill: {
        name: this.user.fullName,
        email: this.user.email,
        contact: this.user.mobileNumber,
      },
      notes: {
        address: 'Online Shopping',
      },
      theme: { color: '#F1626F' },
    };

    var razorPayObject = new Razorpay(options);
    razorPayObject.open();
  }

  placeOrder(response: any) {
    // console.log(response);
    // console.log(this.finalCost);
    // console.log(this.foodCart);
    this.foodCart.forEach((fc) => {
      this.orderItems.push(
        new OrderItem(0, fc.foodItem.id, fc.quantity, fc.foodItem.restaurantId)
      );
    });

    const transactionId = response.razorpay_payment_id;

    this.order = new Order(
      0,
      this.totalCost,
      this.user.id,
      this.addresses[this.selectedAddress].id,
      'Ordered',
      this.orderItems,
      transactionId,
      '',
      this.foodCart[0].foodItem.restaurantId
    );
    this.orderService.placeOrder(this.order).subscribe((data) => {
      console.log('called');

      this.ngZone.run(() => {
        this.router.navigateByUrl('/order-status/' + data.id);
      });
    });
  }
}
