//Code for the cart functionality
//Make sure the page is done loading
if (document.readyState == 'loading') {

  document.addEventListener('DOMContentLoaded', ready());
}
else {
  ready();
}

function ready() {
  //Select all buttons that remove from the cart
  let removeItemButtons = document.getElementsByClassName('btn-danger');

  //Loop through all the buttons and remove all items from the cart when clicked
  for (let i = 0; i < removeItemButtons.length; i++) {
    let button = removeItemButtons[i];
    button.addEventListener('click', removeCartItem);
  }//end for

  //Control for invalid quantities in the cart
  let quantityInputs = document.getElementsByClassName('cart-quantity-input');
  for (let i = 0; i < quantityInputs.length; i++) {
    let input = quantityInputs[i];
    input.addEventListener('change', quantityChanged);
  }//end for

  let addToCartButtons = document.getElementsByClassName('menuItemButton');
  for (let i = 0; i < addToCartButtons.length; i++) {
    let button = addToCartButtons[i];
    button.addEventListener('click', addToCartClicked);

  }//end for

  //Event listener for when purchase is clicked. calls function that empties the cart
  document.getElementsByClassName('btn-purchase')[0].addEventListener('click', purchaseClicked);

}//end ready

//When purchase button is clicked, empty the cart and reset total
function purchaseClicked() {
  alert('Thank you for your purchase');
  let cartItems = document.getElementsByClassName('cart-items')[0];

  while (cartItems.hasChildNodes()) {
    cartItems.removeChild(cartItems.firstChild);
  }//end while
  updateCartTotal();
}//end purchaseClicked

//Remove an item from the cart
function removeCartItem(event) {
  let buttonClicked = event.target
  buttonClicked.parentElement.parentElement.remove();
  updateCartTotal();
}//end removeCartItem

//Quantity changed
function quantityChanged(event) {
  let input = event.target;
  //Is value a number
  if (isNaN(input.value) || input.value <= 0) {
    input.value = 1;
  }
  updateCartTotal();
}

//Add item to cart when button is clicked
function addToCartClicked(event) {
  let button = event.target

  //Get item name, price, quantity, and image (if necessary)
  let shopItem = button.parentElement.parentElement;
  let title = shopItem.getElementsByClassName('shop-item-title')[0].innerText;
  let price = shopItem.getElementsByClassName('shop-item-price')[0].innerText;
  let type = shopItem.getElementsByClassName('shop-item-type')[0].innerText;
  //get src of the image (if necessary)

  console.log('shopItem = ' + shopItem + 'title' + title + 'price = ' + price)

  //Add the item to the tab and then update tab
  addItemToCart(title, price, type);
  updateCartTotal();

}//end addToCartClicked

//Add selected items to the cart
function addItemToCart(title, price, type) {
  //Create a cart row for the item
  let cartRow = document.createElement('div');
  cartRow.classList.add('cart-row');
  let cartItems = document.getElementsByClassName('cart-items')[0];

  let cartItemNames = cartItems.getElementsByClassName('cart-item-title');
  for (let i = 0; i < cartItemNames.length; i++) {
    if (cartItemNames[i].innerText == title) {
      alert('This item is already in your cart');
      return;
    }
  }

  //Use html code to actually create the contents
  let cartRowContents = `
    <div class="cart-item cart-column">
      <span class="cart-item-title" style = "font-weight: 700;">${title}</span>
    </div>
    <span class = cart-item-type cart-column" style="border-bottom: 1px solid black;">${type}</span>
    <span class="cart-price cart-column">${price}</span>
      <div class="cart-quantity cart-column">
      <input class="cart-quantity-input" type="number" value="1">
      <button type="button" class="btn btn-danger">Remove</button>
    </div>`;
//for images instead of the src put ${imageSrc}
  cartRow.innerHTML = cartRowContents;
  cartItems.append(cartRow);

  //Add eventListener to remove button so it works when page loads

  cartRow.getElementsByClassName('btn-danger')[0].addEventListener('click', removeCartItem);
  cartRow.getElementsByClassName('cart-quantity-input')[0].addEventListener('change',  quantityChanged);


}//end addItemToCart

//Get every item from every row in the cart, loop through them for price and quantity, multiply them and add to total
function updateCartTotal() {
  //Get the first cart item in the list of cart items
  let cartItemContainer = document.getElementsByClassName('cart-items')[0];
  //Get all cart rows as an array
  let cartRows = cartItemContainer.getElementsByClassName('cart-row');
  //Cart total
  let total = 0;

  //Loop through cart rows for price and quantity
  for (let i = 0; i < cartRows.length; i++) {
    let cartR = cartRows[i];
    let priceElement = cartR.getElementsByClassName('cart-price')[0];
    let quantityElement = cartR.getElementsByClassName('cart-quantity-input')[0];

    //Get the price(remove $ sign) and quantity, multiply them and add it to the total
    let price = parseFloat(priceElement.innerText.replace('$', ''));
    let quantity = quantityElement.value;
    total = total + (price * quantity);
  }//end for

    //Round total to the nearest 2 decimal places
    total = Math.round(total * 100) / 100;
    document.getElementsByClassName('cart-total-price')[0].innerText = '$' + total + '.00';
}//end updateCartTotal